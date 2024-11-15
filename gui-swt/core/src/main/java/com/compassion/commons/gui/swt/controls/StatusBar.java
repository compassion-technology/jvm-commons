package com.compassion.commons.gui.swt.controls;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

import com.compassion.commons.gui.Controller;
import com.compassion.commons.gui.UserInterface.MessageType;
import com.compassion.commons.gui.swt.controls.builders.SWTBuilders;
import com.compassion.commons.gui.swt.events.FocusLostLambda;
import com.compassion.commons.gui.swt.events.MouseUpLambda;
import com.compassion.commons.gui.swt.events.SelectionLambda;
import com.compassion.commons.gui.swt.image.ImageScaler;
import com.compassion.commons.gui.swt.util.SWTUtilities;

/**
 * A status bar is a composite, usually at the bottom of a screen, that consists
 * of a status message label, a progress bar, a cancel button, and other custom sections.
 * Use the message label to relay messages or errors to the user (see
 * {@link #setMessage(MessageType, String)}), the status label and progress bar to 
 * monitor long-running tasks, and use the other sections to inform the user of program state
 * (for example, the coordinates the mouse is currently hovering over or if the CAPSLOCK key is on)
 * @author John Dimeo
 */
public class StatusBar implements SWTBuilders {
	// Scale the maximum selection value on the progress bar so we have granularity
	private static final int SCALE = 1000;
	private static final DateFormat TF = DateFormat.getTimeInstance();
	private static final int MAX_MESSAGES = 200;
	
	private Image[] images;
	private String  defaultStatus = "Ready.";
	
	private Display     disp;
	private Composite   comp;
	private CLabel      status;
	private Label[]     custom;
	private ProgressBar barD, barI;
	private Button      cancel;
	private boolean     cancelable;

	private Deque<String> log = new LinkedList<>();
	
	public StatusBar(Controller c, Composite parent, int style) {
		this(c, parent, style, 0, (SelectionLambda) e -> c.cancelTask());
	}
	
	/**
	 * Creates a new status bar.
	 * @param c the program's controller.  This is required so that the status bar can cancel the
	 * currently running task if the user presses the cancel button.  If the cancel button is always
	 * disabled, this can be {@code null}
	 * @param parent the parent composite on which to create the status bar.  You can access the
	 * status bar's composite via {@link #getComposite()} to set layout data
	 * @param style the style to use when creating the composite that holds all the status bar
	 * controls.  This should generally be {@code SWT.NONE} since the status bar will draw its own
	 * {@code SWT.SEPARATOR} labels, but can be any of the style bits honored by {@link Composite} 
	 * @param customSections the number of custom labels to create to display additional program 
	 * state, like mouse coordinates.
	 * @param cancelAction what to do when the cancel button is pressed. By default {@link Controller#cancelTask()}
	 * is called.
	 */
	public StatusBar(final Controller c, final Composite parent, int style, int customSections, SelectionListener cancelAction) {
		disp = parent.getDisplay();
		images = new Image[MessageType.values().length];
		images[MessageType.WARN.ordinal()]  = scale(disp, SWT.ICON_WARNING);
		images[MessageType.ERROR.ordinal()] = scale(disp, SWT.ICON_ERROR);
		images[MessageType.INFO.ordinal()]  = scale(disp, SWT.ICON_INFORMATION);
		images[MessageType.HELP.ordinal()]  = scale(disp, SWT.ICON_QUESTION);
		
		int cols = 2 * customSections + 5;
		
		comp = composite(parent, style).layout(grid(cols).hMargin(0).vMargin(0, 4)).get();
		
		separator(comp, SWT.HORIZONTAL).layoutData(gridData().hFill().hSpan(cols));
			
		status = new CLabel(comp, SWT.NONE);
		status.setLayoutData(gridData().hFill().get());
		status.setToolTipText("Click to display a log of status messages.");
		status.setText(defaultStatus);
		
		custom = new Label[customSections];
		Label[] separators = new Label[customSections + 1];
		
		for (int i = 0; i <= customSections; i++) {
			separators[i] = separator(comp, SWT.VERTICAL).get();
			if (i < customSections) {
				custom[i] = label(comp).layoutData(gridData().hAlign(SWT.FILL)).get();
			}
		}
		
		Composite bars = composite(comp).layoutData(gridData().align(SWT.FILL).width(128)).layout(stack()).get();
			barD = new ProgressBar(bars, SWT.BORDER);
			barI = new ProgressBar(bars, SWT.BORDER | SWT.INDETERMINATE);
			barD.setMaximum(SCALE);
			SWTUtilities.setTopControl(barD);
			
		cancel = new Button(comp, SWT.PUSH | SWT.CENTER);
			cancel.setText("Cancel");
			cancel.setToolTipText("Cancels the current task");
			cancel.setEnabled(cancelable);
			cancel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
			cancel.addSelectionListener(cancelAction);
			
		int height = cancel.computeSize(SWT.DEFAULT, SWT.DEFAULT).y;
		for (int i = 0; i < separators.length; i++) {
			separators[i].setLayoutData(new GridData(SWT.DEFAULT, height));
		}

		status.addMouseListener((MouseUpLambda) me -> {
			Shell s = new Shell(parent.getDisplay(), SWT.NO_TRIM | SWT.ON_TOP);
			s.setLayout(fill().margin(5).get());
			List l = new List(s, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
			l.setBackground(s.getDisplay().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
			log.forEach(str -> l.add(str));
			
			Point p = s.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			s.setSize(status.getSize().x, Math.min(p.y, 256));
			
			p = status.getParent().toDisplay(status.getLocation());
			s.setLocation(p.x, p.y - s.getSize().y);
			s.setVisible(true);
			l.setTopIndex(l.getItemCount() - 1);
			s.forceFocus();
			s.addFocusListener((FocusLostLambda) fe -> {
				// *Don't* use SWTUtilities.run() as it will run immediately
				// on the UI thread instead of waiting until later after the
				// focus event has been completely handled/consumed.
				fe.display.asyncExec(() -> fe.widget.dispose());
			});
		});
			
		status.addDisposeListener(e -> Arrays.stream(images).filter(i -> i != null).forEach(i -> i.dispose()));
	}
	
	public Image getImage(MessageType type) {
		return images[type.ordinal()];
	}
	
	public Composite getComposite() { return comp; }
	
	public void setProgress(String message, long progress, long size) {
		progress = Math.round((SCALE * progress) / (double) size);
		SWTUtilities.run(disp, new SetStatus(message, (int) progress, size >= 0L));
	}

	public void setMessage(MessageType type, String msg) {
		SWTUtilities.run(disp, new SetMessage(type, msg, true));
	}
	
	public void setCustomText(String... text) {
		SWTUtilities.run(disp, new SetText(text));
	}
	public void setCustomText(int index, String text) {
		SWTUtilities.run(disp, new SetText(index, text));
	}
	
	public Label getCustomLabel(int index) {
		return custom[index];
	}
	
	/**
	 * Sets the enabled state of the cancel button.
	 * @param enabled the enabled state of the cancel button
	 */
	public void setCancelEnabled(final boolean enabled) {
		// Avoid redundant calls
		if (cancelable != enabled) {
			SWTUtilities.run(disp, () -> {
				if (cancel.isDisposed()) { return; }
				cancel.setEnabled(enabled);
				cancelable = enabled;
			});
		}
	}
	
	/**
	 * Sets the displayed text in the status bar.
	 * @param defaultStatus the default status when no task is running;
	 * the default value is {@code "Ready."}
	 * @param cancelCaption the caption for the button that cancels the
	 * current task; the default value is {@code "Cancel"}
	 */
	public void setText(String defaultStatus, String cancelCaption) {
		this.defaultStatus = defaultStatus;
		setMessage(MessageType.DEFAULT, null);
		
		cancel.setText(cancelCaption);
		cancel.getParent().layout(true);
	}
	
	private class SetStatus implements Runnable {
		private String  message;
		private int     progress;
		private boolean determinate;
		
		SetStatus(String message, int progress, boolean determinate) {
			this.message = message; this.progress = progress; this.determinate = determinate;
		}
		
		@Override
		public void run() {
			if (isDisposed()) { return; }
			
			status.setImage(getImage(MessageType.DEFAULT));
			new SetMessage(MessageType.DEFAULT, message, false).run();
			if (determinate) {
				barD.setSelection(progress);
				SWTUtilities.setTopControl(barD);
			} else {
				SWTUtilities.setTopControl(barI);
			}
		}
	}
	
	private class SetMessage implements Runnable {
		private String      message;
		private MessageType type;
		private boolean     resetBar;
		
		SetMessage(MessageType type, String message, boolean resetBar) {
			this.type = type; this.message = message; this.resetBar = resetBar;
		}
		
		@Override
		public void run() {
			if (isDisposed()) { return; }
			
			status.setImage(getImage(type));
			if (type == MessageType.ERROR) {
				disp.beep();
			}
			if (resetBar) {
				barD.setSelection(0);
				SWTUtilities.setTopControl(barD);
			}
			
			message = (message == null)? defaultStatus : message.trim();
			if (message.equals(status.getText().trim()) || message.isEmpty()) { return; }
			
			status.setText(message);
			if (!message.equals(defaultStatus)) {
				log.addLast(TF.format(new Date()) + ": " + message);
			}
			if (log.size() > MAX_MESSAGES) {
				log.removeFirst();
			}
		}
	}
	
	private class SetText implements Runnable {
		private String[] allText;
		private int index;
		private String text;
		
		SetText(String[] allText) {
			this.allText = allText;
		}
		SetText(int index, String text) {
			this.index = index; this.text = text;
		}
		
		@Override
		public void run() {
			if (isDisposed()) { return; }
			
			if (allText != null) {
				for (int i = 0; i < allText.length && i < custom.length; i++) {
					custom[i].setText(allText[i]);
				}
			} else {
				custom[index].setText(text);
			}
			custom[0].getParent().layout();
		}
	}
	
	private static Image scale(Display d, int icon) {
		ImageData data = d.getSystemImage(icon).getImageData();
		return new Image(d, ImageScaler.scaleImage(data, 16, 16));
	}
	
	public boolean isDisposed() {
		return status.isDisposed();
	}
}
