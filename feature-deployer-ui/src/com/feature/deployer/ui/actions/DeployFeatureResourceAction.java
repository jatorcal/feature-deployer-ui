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
package com.feature.deployer.ui.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.actions.ActionDelegate;

import com.feature.deployer.ui.activator.Activator;
import com.feature.deployer.ui.wizards.DeployFeatureWizard;

/**
 * Action to move a remote resource on repository
 */
public class DeployFeatureResourceAction extends ActionDelegate implements IWorkbenchWindowActionDelegate, 
	IObjectActionDelegate, IViewActionDelegate {
	
	// The shell, required for the progress dialog
	protected Shell shell;

	/* (non-Javadoc)
	 * @see org.tigris.subversion.subclipse.ui.actions.SVNAction#execute(org.eclipse.jface.action.IAction)
	 */
	protected void execute(IAction action) {
          
		System.out.println(action);
		
		DeployFeatureWizard wizard = new DeployFeatureWizard("Path");
		
		WizardDialog dialog = new WizardDialog(getShell(), wizard);
        wizard.setParentDialog(dialog);
        dialog.open();

	}

	/**
	 * Convenience method for getting the current shell.
	 * 
	 * @return the shell
	 */
	public Shell getShell() {
		if (shell != null) {
			return shell;
		} else {
			IWorkbench workbench = Activator.getPlugin().getWorkbench();
			if (workbench == null) return null;
			IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
			if (window == null) return null;
			return window.getShell();
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.team.internal.ui.actions.TeamAction#isEnabled()
	 */
	protected boolean isEnabled() {
		return true;
	}

	/*
	 * @see org.tigris.subversion.subclipse.ui.actions.ReplaceableIconAction#getImageId()
	 */
	protected String getImageId() {
		return "";
	}

	@Override
	public void init(IViewPart arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActivePart(IAction arg0, IWorkbenchPart arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IWorkbenchWindow arg0) {
		// TODO Auto-generated method stub
		
	}

}
