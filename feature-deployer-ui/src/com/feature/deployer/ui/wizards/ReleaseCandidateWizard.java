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


import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;

import com.feature.deployer.ui.activator.Activator;
import com.feature.deployer.ui.pages.ReleaseCandidateWizardPage;

/**
 * Wizard to move a remote resource
 */
public class ReleaseCandidateWizard extends Wizard {
	
    private String path;
    private Dialog parentDialog;
	
   
	public ReleaseCandidateWizard(String path) {
		super();
		setWindowTitle("Release Candidate"); //$NON-NLS-1$
        this.path = path;
        setNeedsProgressMonitor(true);
	}

	/**
	 * Creates the wizard pages
	 */
	@SuppressWarnings("static-access")
	public void addPages() {
		
		
		String pageTitle = "Crear Release Candidate"; //$NON-NLS-1$
        String pageDescription = "Se creará una release candidate a partir de los datos mostrados."; //$NON-NLS-1$
        ImageDescriptor image = Activator.getPlugin().getImageDescriptor("sample.png");
        
		// add the main page
		ReleaseCandidateWizardPage releaseCandidateWizardPage = new ReleaseCandidateWizardPage(
            "releaseCandidateWizardPage",  //$NON-NLS-1$ 
            pageTitle, //$NON-NLS-1$
            image,
            pageDescription, this.path);
        
		addPage(releaseCandidateWizardPage);
        
	}
    
	/*
	 * @see IWizard#performFinish
	 */
	public boolean performFinish() {
        try {
        	Activator.runWithProgress(getContainer().getShell(), false /*cancelable*/, new IRunnableWithProgress() {
                public void run(IProgressMonitor monitor) throws InvocationTargetException {
                    /*try {
                        SVNProviderPlugin.getPlugin().getRepositoryResourcesManager().
                            moveRemoteResource(
                                selection,mainPage.getParentFolder(),
                                mainPage.getResourceName(),
                                commitCommentPage.getComment(),monitor);
                        
                    } catch (SVNException e) {
                        throw new InvocationTargetException(e);
                    }*/
                }
            });
        } catch (InterruptedException e) {
            // operation canceled
        } catch (InvocationTargetException e) {
            //Activator.openError(getContainer().getShell(), "", null, e.getCause()); //$NON-NLS-1$
            return false;
        }
	   return true;
	}
    
    /**
     * Method setParentDialog.
     * @param dialog
     */
    public void setParentDialog(Dialog dialog) {
        this.parentDialog = dialog;
    }
    
    public void finishAndClose() {
    	
    }    
    
}
