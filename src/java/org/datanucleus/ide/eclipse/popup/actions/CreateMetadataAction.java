/**********************************************************************
Copyright (c) 2005 Michael Grundmann and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
 ...
**********************************************************************/
package org.datanucleus.ide.eclipse.popup.actions;

import org.datanucleus.ide.eclipse.wizard.createmetadata.MetadataCreationWizard;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;

/**
 * Action to create a JDO package.jdo file.
 */
public class CreateMetadataAction extends JavaProjectAction
{
    /*
     * (non-Javadoc)
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(IAction action)
    {
        // Instantiates and initializes the wizard
        MetadataCreationWizard wizard = new MetadataCreationWizard();
        ISelection selection = getSelection();
        if ((selection instanceof IStructuredSelection) || (selection == null))
        wizard.init(getActivePart().getSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection)selection);
            
        // Instantiates the wizard container with the wizard and opens it
        WizardDialog dialog = new WizardDialog(getActivePart().getSite().getShell(), wizard);
        dialog.create();
        dialog.open();
    }
}
