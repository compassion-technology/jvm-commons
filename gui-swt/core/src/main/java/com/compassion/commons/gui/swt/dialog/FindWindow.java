package com.compassion.commons.gui.swt.dialog;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.compassion.commons.gui.swt.controls.builders.SWTBuilders;
import com.compassion.commons.gui.swt.util.MnemonicUtils;
import com.compassion.commons.gui.swt.util.ResourceManager;
import com.compassion.commons.gui.swt.util.SWTUtilities;
import com.elderresearch.commons.icons.ms.IconsMS;

/**
 * A general "find" dialog box that is stylistically similar to those dialogs accessible
 * via "Ctrl + F" in most applications.
 * @author John Dimeo
 */
public class FindWindow extends Dialog implements SWTBuilders {
	public enum FindDirection { NEXT, PREVIOUS }
	
	public static class FindQuery {
		private FindDirection direction;
		private Object query;
		private Set<Enum<?>> locations;
		private boolean regex;
		private boolean matchCase;
		
		/**
		 * Constructs a new find query.
		 * @param query the search query, which should be interpreted as a regular expression if {@code regex} is {@code true}
		 * @param regex whether or not the query should be interpreted as a regular expression
		 * @param matchCase whether or not the search engine should match the case of the query
		 * @param locations the enum identifiers of the locations in which to search for the query, or {@code null} if
		 * locations were not specified
		 * @param direction the direction of the search, either {@link FindDirection#NEXT} or {@link FindDirection#PREVIOUS}
		 */
		public FindQuery(String query, boolean regex, boolean matchCase, Set<Enum<?>> locations, FindDirection direction) {
			this.query     = regex? Pattern.compile(query) : query;
			this.regex     = regex;
			this.matchCase = matchCase;
			this.locations = locations;
			this.direction = direction;
		}
		
		@Override
		public boolean equals(Object obj) {
			FindQuery other = (FindQuery) obj;
			if (other.direction == direction
			   && other.query.equals(query)
			   && other.regex == regex
			   && other.matchCase == matchCase) {
				int matching = 0;
				for (Enum<?> e : other.locations) {
					if (locations.contains(e)) { matching++; }
				}
				if (matching == locations.size()) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return direction.ordinal() + query.hashCode() + (regex? 1 : 2) + (matchCase? 1 : 2) + locations.hashCode();
		}
		
		/**
		 * Tests to see if an object matches this find query, applying search options like
		 * {@code regex} and {@code matchCase}.
		 * @param s a string to test
		 * @return if {@code obj} {@linkplain Pattern#matches(String, CharSequence) matches} {@code query}
		 * (if {@code regex} was true), or if {@code obj} {@linkplain String#contains(CharSequence) contains}
		 * {@code query}
		 */
		public boolean matches(String s) {
			if (regex)     { return ((Pattern) query).matcher(s).matches(); }
			if (matchCase) { return s.contains(query.toString()); }
			return s.toLowerCase().contains(query.toString().toLowerCase());
		}
		
		/**
		 * Tests to see if the user instructed the search engine to search in {@code location}.
		 * @param location an enum describing a location to search
		 * @return if this query's set of locations contains {@code location}
		 */
		public boolean containsLocation(Enum<?> location) {
			return locations.contains(location);
		}
		
		/**Gets the direction of the query, either {@link FindDirection#NEXT} or {@link FindDirection#PREVIOUS}.
		 * @return the direction of the search query*/
		public FindDirection getDirection() { return direction; }
		
		@Override
		public String toString() { return query.toString(); }
	}
	
	private Stack<String> queries = new Stack<>();
	private List<FindListener> listeners = new LinkedList<>();
	private Enum<?>[] locations;
	private Shell s;
	private Map<Enum<?>, Button> locationButtons;
	private Button matchCase, regex;
	private CCombo query;
	private Map<String, FindQuery> queryCache = new HashMap<>();
	private ResourceManager rm;
	
	/**
	 * Constructs a new find window.  Each application should usually only create
	 * one dialog.
	 * @param rm the resource manager to use to allocate images needed by the dialog
	 * @param parent the shell on which to create the dialog.  The dialog will be
	 * <i>modeless</i> (see {@link SWT#MODELESS})
	 * @param locations the string identifiers of the locations to search.  The
	 * user can select one or more of these locations from the dialog.
	 */
	public FindWindow(ResourceManager rm, Shell parent, Enum<?>[] locations) {
		super(parent, SWT.NONE);
		this.rm = rm;
		this.locations = locations;
	}
	
	/**
	 * Adds a listener that will be notified when the user clicks "Find Next" or "Find Previous". 
	 * @param fl the listener to add
	 */
	public void addListener(FindListener fl)    { listeners.add(fl);    }
	/**
	 * Removes a listener from the list of listeners that will be notified when the user clicks
	 * "Find Next" or "Find Previous".
	 * @param fl the listener to add
	 */
	public void removeListener(FindListener fl) { listeners.remove(fl); }
	
	/**
	 * Opens or activates (if the dialog has already been opened) the find window.  This
	 * method returns immediately; use {@link #addListener(FindListener)} to add listener
	 * that will be notified when the user clicks "Find Next" or "Find Previous"
	 */
	public void open() {
		if (s == null || s.isDisposed()) {
			s = new Shell(getParent(), SWT.MODELESS | SWT.DIALOG_TRIM);
		} else {
			s.setActive();
			return;
		}
		
		s.setText("Find");
		s.setImage(rm.getImage(IconsMS.FIND));
		s.setLayout(grid(1, 1, 1).get());
		
		label(s).text(MnemonicUtils.getMnemonic(s, "Find what: ", null));
		
		query = new CCombo(s, SWT.BORDER);
			GridData data = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
			data.widthHint = 150;
			query.setLayoutData(data);
			if (!queries.isEmpty()) { query.setText(queries.peek()); }
		
		locationButtons = new HashMap<>();
		if (locations != null) {
			int i = 0;
			for (Enum<?> location : locations) {
				String str = location.toString();
				if (i % 2 == 0) {
					Label l = new Label(s, SWT.NONE);
					if (i == 0) { l.setText("Find in:"); }
				}
				
				locationButtons.put(location, check(s).selected(true).text(MnemonicUtils.getMnemonic(s, str, null)).get());
				i++;
			}
			if (i % 2 > 0) { new Label(s, SWT.NONE); }
		}
		
		SWTUtilities.addSeperator(rm, s, "Search options", null, SWT.BOLD)
			.setLayoutData(gridData().hFill().hSpan(3));
		
		data = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
		data.horizontalIndent = 12;
		matchCase = new Button(s, SWT.CHECK);
			matchCase.setText(MnemonicUtils.getMnemonic(s, "Match case", 'c'));
			matchCase.setLayoutData(data);
		regex = new Button(s, SWT.CHECK);
			regex.setText(MnemonicUtils.getMnemonic(s, "Parse query  as regular expression", 'r'));
			regex.setLayoutData(data);
		
		Composite buttons = new Composite(s, SWT.NONE);
			data = new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1);
			data.verticalIndent = 16;
			buttons.setLayoutData(data);
			GridLayout layout = new GridLayout(3, false);
			layout.marginHeight = layout.marginWidth = 0;
			buttons.setLayout(layout);
		new Label(buttons, SWT.NONE).setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		data = new GridData(SWT.RIGHT, SWT.BOTTOM, false, false);
		data.widthHint = 82;
		Button prev = new Button(buttons, SWT.PUSH);
			prev.setText(MnemonicUtils.getMnemonic(s, "Find Previous", 'p'));
			prev.setLayoutData(data);
			prev.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					notifyListeners(FindDirection.PREVIOUS);
				}
			});
		final Button next = new Button(buttons, SWT.PUSH);
			next.setText(MnemonicUtils.getMnemonic(s, "Find Next", 'n'));
			s.setDefaultButton(next);
			next.setLayoutData(data);
			next.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					notifyListeners(FindDirection.NEXT);
				}
			});
			
		query.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.CR) {
					SWTUtilities.selectAndNotify(next);
				}
			}
		});
		query.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FindQuery q = queryCache.get(query.getText());
				if (q != null) {
					regex.setSelection(q.regex);
					matchCase.setSelection(q.matchCase);
					for (Button b : locationButtons.values()) {
						b.setSelection(false);
					}
					for (Enum<?> loc : q.locations) {
						locationButtons.get(loc).setSelection(true);
					}
				}
			}
		});
			
		s.pack();
		SWTUtilities.centerShell(s);
		SWTUtilities.open(s);
	}
	
	private void notifyListeners(FindDirection dir) {
		Set<Enum<?>> locs = new HashSet<>();
		for (Entry<Enum<?>, Button> entry : locationButtons.entrySet()) {
			if (entry.getValue().getSelection()) {
				locs.add(entry.getKey());
			}
		}
		try {
			FindQuery q = new FindQuery(query.getText(), regex.getSelection(), matchCase.getSelection(), locs, dir);
			if (!queryCache.containsKey(q.query)) {
				query.add(q.toString());
			}
			queryCache.put(q.toString(), q);
			
			for (FindListener fl : listeners) {
				fl.handleQuery(q);
			}
		} catch (PatternSyntaxException ex) {
			for (FindListener fl : listeners) {
				fl.handleError("Could not parse \"" + query.getText() + "\" as a regular expression.");
			}
		}
	}
	
	public interface FindListener {
		void handleQuery(FindQuery query);
		void handleError(String message);
	}
}
