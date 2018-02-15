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
package com.feature.deployer.ui.wizards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;

import com.feature.deployer.ui.activator.Activator;
import com.feature.deployer.ui.pages.DeployFeatureWizardPage1;
import com.feature.deployer.ui.pages.DeployFeatureWizardPage2;

/**
 * Wizard to move a remote resource
 */
public class DeployFeatureWizard extends Wizard {

	private String path;
	private Dialog parentDialog;

	public DeployFeatureWizard(String path) {
		super();
		setWindowTitle("Titulo ventana"); //$NON-NLS-1$
		this.path = path;
		setNeedsProgressMonitor(true);
	}

	/**
	 * Creates the wizard pages
	 */
	@SuppressWarnings("static-access")
	public void addPages() {

		String pageTitle = "Despliegue de features"; //$NON-NLS-1$
		String pageDescription = "Selecciona las opciones del wizard para desplegar tu/s feature/s."; //$NON-NLS-1$
		ImageDescriptor image = Activator.getPlugin().getImageDescriptor("sample.png");

		// Shared map
		Hashtable map = new Hashtable();
		
		
		// add the main page
		DeployFeatureWizardPage1 page1 = new DeployFeatureWizardPage1(
				"DeployFeatureWizardPage1",
				pageTitle,
				image, 
				pageDescription, map);
		
		page1.comboBoxIncludesFront.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

            	if (page1.comboBoxIncludesFront.getSelectedItem().equals("Sí")){
					page1.setIncludesFront(true);
				} else {
					page1.setIncludesFront(false);
				}
            }
        });
		
		
		DeployFeatureWizardPage2 page2 = new DeployFeatureWizardPage2("DeployFeatureWizardPage2", pageTitle,
				Activator.getPlugin().getImageDescriptor("sample.png"), pageDescription, map);
		addPage(page2);

	}

	/*
	 * @see IWizard#performFinish
	 */
	public boolean performFinish() {
		try {
			Activator.runWithProgress(getContainer().getShell(), false /* cancelable */, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException {
					/*
					 * try { SVNProviderPlugin.getPlugin().getRepositoryResourcesManager().
					 * moveRemoteResource( selection,mainPage.getParentFolder(),
					 * mainPage.getResourceName(), commitCommentPage.getComment(),monitor);
					 * 
					 * } catch (SVNException e) { throw new InvocationTargetException(e); }
					 */
				}
			});
		} catch (InterruptedException e) {
			// operation canceled
		} catch (InvocationTargetException e) {
			// Activator.openError(getContainer().getShell(), "", null, e.getCause());
			// //$NON-NLS-1$
			return false;
		}
		return true;
	}

	/**
	 * Method setParentDialog.
	 * 
	 * @param dialog
	 */
	public void setParentDialog(Dialog dialog) {
		this.parentDialog = dialog;
	}

	public void finishAndClose() {

	}

}
