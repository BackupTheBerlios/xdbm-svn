/*
 * Project: xmldb-manager 
 * Copyright (C) 2005  Manuel Pichler <manuel.pichler@xplib.de>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

/*
 * $Log$
 */
package de.xplib.xdbm.ui.resource;

import de.xplib.xdbm.ui.Application;
import de.xplib.xdbm.ui.ApplicationMenuBar;
import de.xplib.xdbm.ui.Plugin;
import de.xplib.xdbm.ui.widgets.InternalFrame;
import de.xplib.xdbm.ui.widgets.InternalFramePanel;

/**
 *  
 * @author Manuel Pichler <manuel.pichler@xplib.de>
 * @version $Revision$
 */
public class ResourcePlugin implements Plugin {
    
    private ResourcePanel instance = null;

    /**
     * 
     */
    public ResourcePlugin() {
        super();
    }
    
    public String getTitle() {
        return "ResourceView";
    }

    /**
     * <Some description here>
     * 
     * @return
     * @see de.xplib.xdbm.ui.Plugin#hasPanel()
     */
    public boolean hasPanel() {
        return true;
    }

    /**
     * <Some description here>
     * 
     * @return
     * @see de.xplib.xdbm.ui.Plugin#getPanelInstance()
     */
    public InternalFramePanel getPanelInstance(Application appIn) {
        if (this.instance == null) {
            this.instance = new ResourcePanel(appIn);
        }
        return this.instance;
    }
    
    public String getPosition() {
        return InternalFrame.CENTER;
    }


    /**
     * <Some description here>
     * 
     * @return
     * @see de.xplib.xdbm.ui.Plugin#hasDialog()
     */
    public boolean hasDialog() {
        // TODO Auto-generated method stub
        return false;
    }
    /**
     * <Some description here>
     * 
     * @param appIn
     * @see de.xplib.xdbm.ui.Plugin#openDialog(de.xplib.xdbm.ui.Application)
     */
    public void openDialog(Application appIn) {
    }
    
    /**
     * <Some description here>
     * 
     * @param menuBarIn
     * @see de.xplib.xdbm.ui.Plugin#setUpMenu(de.xplib.xdbm.ui.ApplicationMenuBar)
     */
    public void setUpMenu(ApplicationMenuBar menuBarIn) {
        // TODO Auto-generated method stub

    }
}
