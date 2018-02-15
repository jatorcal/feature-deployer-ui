/*******************************************************************************
 * Copyright (c) 2003, 2006 Subclipse project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Subclipse project committers - initial API and implementation
 ******************************************************************************/
package com.feature.deployer.ui.pages;


import java.util.Hashtable;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

import com.feature.deployer.ui.activator.Activator;

/**
 * Common superclass for SVN wizard pages. Provides convenience methods
 * for widget creation.
 */
public class DeployFeatureParentWizardPage extends WizardPage {
	
	protected DeployFeatureParentWizardPage(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
	}

	protected static final int LABEL_WIDTH_HINT = 400;
	protected static final int LABEL_INDENT_WIDTH = 32;
	protected static final int LIST_HEIGHT_HINT = 100;
	protected static final int SPACER_HEIGHT = 8;
	
	protected static Hashtable dataBetweenpages;

	
	public DeployFeatureParentWizardPage(
			String pageName, String title, 
			ImageDescriptor titleImage, 
			String description, 
			Hashtable dataBetweenpages) {
		super(pageName, title, titleImage);
		setDescription(description);
		setDataBetweenpages(dataBetweenpages);
	}

	public Hashtable getDataBetweenpages() {
		return dataBetweenpages;
	}

	public void setDataBetweenpages(Hashtable dataBetweenpages) {
		this.dataBetweenpages = dataBetweenpages;
	}

	@Override
	public void createControl(Composite parent) {
		DeployFeatureWizardPage1 page2 = new DeployFeatureWizardPage1("DeployFeatureWizardPage2", "",
				Activator.getPlugin().getImageDescriptor("sample.png"), "", dataBetweenpages);
	}
	
	
	
}
