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


import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Common superclass for SVN wizard pages. Provides convenience methods
 * for widget creation.
 */
public class ReleaseCandidateWizardPage extends WizardPage {
	protected static final int LABEL_WIDTH_HINT = 400;
	protected static final int LABEL_INDENT_WIDTH = 32;
	protected static final int LIST_HEIGHT_HINT = 100;
	protected static final int SPACER_HEIGHT = 8;

	private String path;
	
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(2, false));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		//getWizard().getContainer().updateButtons();
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setText("Se procederá a crear una release candidate sobre el siguiente directorio:");
		new Label(container, SWT.NONE);
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText(path);
	}
		
	/**
	 * SVNWizardPage constructor comment.
	 * @param pageName  the name of the page
	 * @param title  the title of the page
	 * @param titleImage  the image for the page
	 * @param description the description of the page
	 */
	public ReleaseCandidateWizardPage(
			String pageName,
			String title,
			ImageDescriptor titleImage,
			String description,
			String path) {
		super(pageName, title, titleImage);
		setDescription(description);
		setPath(path);
	}
	/**
	 * Creates a new checkbox instance and sets the default layout data.
	 *
	 * @param group  the composite in which to create the checkbox
	 * @param label  the string to set into the checkbox
	 * @return the new checkbox
	 */ 
	protected Button createCheckBox(Composite group, String label) {
		Button button = new Button(group, SWT.CHECK | SWT.LEFT);
		button.setText(label);
		GridData data = new GridData();
		data.horizontalSpan = 2;
		button.setLayoutData(data);
		return button;
	}
	/**
	 * Utility method that creates a combo box
	 *
	 * @param parent  the parent for the new label
	 * @return the new widget
	 */
	protected Combo createCombo(Composite parent) {
		Combo combo = new Combo(parent, SWT.READ_ONLY);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		combo.setLayoutData(data);
		return combo;
	}
	/**
	 * Creates composite control and sets the default layout data.
	 *
	 * @param parent  the parent of the new composite
	 * @param numColumns  the number of columns for the new composite
	 * @return the newly-created coposite
	 */
	protected Composite createComposite(Composite parent, int numColumns) {
		Composite composite = new Composite(parent, SWT.NULL);
	
		// GridLayout
		GridLayout layout = new GridLayout();
		layout.numColumns = numColumns;
		composite.setLayout(layout);

	
		// GridData
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		
		composite.setLayoutData(data);
		
		
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		//composite.setLayout(frame.getContentPane().getLayout());
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblllevoFront = new JLabel("¿Llevo front?");
		lblllevoFront.setBounds(12, 60, 125, 15);
		panel.add(lblllevoFront);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(140, 55, 47, 24);
		comboBox.addItem("Sí");
		comboBox.addItem("No");
		Dimension d = new Dimension(50,20);
		comboBox.setSize(d);
		panel.add(comboBox);
		
		
		return composite;
	}
	/**
	 * Utility method that creates a label instance
	 * and sets the default layout data.
	 *
	 * @param parent  the parent for the new label
	 * @param text  the text for the new label
	 * @return the new label
	 */
	public static Label createLabel(Composite parent, String text) {
		return createIndentedLabel(parent, text, 0);
	}
	/**
	 * Utility method that creates a label instance indented by the specified
	 * number of pixels and sets the default layout data.
	 *
	 * @param parent  the parent for the new label
	 * @param text  the text for the new label
	 * @param indent  the indent in pixels, or 0 for none
	 * @return the new label
	 */
	public static Label createIndentedLabel(Composite parent, String text, int indent) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(text);
		GridData data = new GridData();
		data.horizontalSpan = 1;
		data.horizontalAlignment = GridData.FILL;
		data.horizontalIndent = indent;
		label.setLayoutData(data);
		return label;
	}
	/**
	 * Utility method that creates a label instance with word wrap and sets
	 * the default layout data.
	 *
	 * @param parent  the parent for the new label
	 * @param text  the text for the new label
	 * @param indent  the indent in pixels, or 0 for none
	 * @param widthHint  the nominal width of the label
	 * @return the new label
	 */
	protected Label createWrappingLabel(Composite parent, String text, int indent) {
		return createWrappingLabel(parent, text, indent, 1);
	}
	
	protected Label createWrappingLabel(Composite parent, String text, int indent, int horizontalSpan) {
		Label label = new Label(parent, SWT.LEFT | SWT.WRAP);
		label.setText(text);
		GridData data = new GridData();
		data.horizontalSpan = horizontalSpan;
		data.horizontalAlignment = GridData.FILL;
		data.horizontalIndent = indent;
		data.grabExcessHorizontalSpace = true;
		data.widthHint = LABEL_WIDTH_HINT;
		label.setLayoutData(data);
		return label;
	}
	
	/**
	 * Create a text field specific for this application
	 *
	 * @param parent  the parent of the new text field
	 * @return the new text field
	 */
	public static Text createTextField(Composite parent) {
		Text text = new Text(parent, SWT.SINGLE | SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.verticalAlignment = GridData.CENTER;
		data.grabExcessVerticalSpace = false;
		data.widthHint = IDialogConstants.ENTRY_FIELD_WIDTH;
		text.setLayoutData(data);
		return text;
	}
	/**
	 * Utility method to create a radio button
	 * 
	 * @param parent  the parent of the radio button
	 * @param label  the label of the radio button
	 * @param span  the number of columns to span
	 * @return the created radio button
	 */
	protected Button createRadioButton(Composite parent, String label, int span) {
		Button button = new Button(parent, SWT.RADIO);
		button.setText(label);
		GridData data = new GridData();
		data.horizontalSpan = span;
		button.setLayoutData(data);
		return button;
	}
	/**
	 * Utility method to create a full width separator preceeded by a blank space
	 * 
	 * @param parent  the parent of the separator
	 * @param verticalSpace  the vertical whitespace to insert before the label
	 */
	protected void createSeparator(Composite parent, int verticalSpace) {
		// space
		Label label = new Label(parent, SWT.NONE);
		GridData data = new GridData();
		data.heightHint = verticalSpace;
		label.setLayoutData(data);
		// separator
		label = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		data = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(data);
	}
	
	
	protected boolean nextPressed() { 
		try {
			System.out.println("");
			//formCompositeBuilder.save(false);
			return true;
		} catch (Exception e) {
			//eclipseContext.get(IEventBroker.class).send("EXCEPTION_SHOW_TO_USER", e);
		}
		return false;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
