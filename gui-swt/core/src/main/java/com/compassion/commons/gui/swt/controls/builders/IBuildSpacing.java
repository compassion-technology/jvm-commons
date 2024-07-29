package com.compassion.commons.gui.swt.controls.builders;

public interface IBuildSpacing<B> {
	B spacing(int spacing);
	
	interface IBuildSpacingAsymmetric<B> extends IBuildSpacing<B> {
		B spacing(int h, int v);
		
		@Override
		default B spacing(int spacing) {
			return spacing(spacing, spacing);
		}	
	}
}
