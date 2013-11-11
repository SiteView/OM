package com.siteview.om;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.addView("com.siteview.om.showincident",IPageLayout.LEFT, 0.3f, layout.getEditorArea());
//		layout.setEditorAreaVisible(false);
	}
}
