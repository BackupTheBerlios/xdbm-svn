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
package de.xplib.xdbm.ui.action;

import java.awt.event.ActionEvent;

import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;

import de.xplib.xdbm.ui.Application;
import de.xplib.xdbm.ui.dialog.NewXMLResourceDialog;
import de.xplib.xdbm.ui.model.UIObject;
import de.xplib.xdbm.ui.model.VirtualCollectionObject;
import de.xplib.xdbm.ui.model.VirtualResourceObject;
import de.xplib.xdbm.ui.model.XapiCollectionObject;
import de.xplib.xdbm.util.UIObjectObserver;

/**
 *  
 * @author Manuel Pichler <manuel.pichler@xplib.de>
 * @version $Revision$
 */
public class NewXMLResourceAction extends I18NAction implements UIObjectObserver {
    
    /**
     * GoF Flyweight instance of NewXMLResourceAction.
     */
    public static final NewXMLResourceAction INSTANCE = new NewXMLResourceAction();

    /**
     * @param keyIn
     */
    public NewXMLResourceAction() {
        super("action.object.new.xml.resource");
               
        this.setEnabled(false);
        this.putValue(SMALL_ICON, Application.createIcon(
                "icon/action.new.resource.xml.png"));
        
        Application.getInstance().addObserver(this);
    }

    /**
     * <Some description here>
     * 
     * @param objectIn
     * @see de.xplib.xdbm.util.UIObjectObserver#update(de.xplib.xdbm.ui.model.UIObject)
     */
    public void update(UIObject objectIn) {
        // TODO Auto-generated method stub
        if (objectIn instanceof VirtualCollectionObject
                || objectIn instanceof VirtualResourceObject
                || objectIn == null) {
            
            this.setEnabled(false);
        } else if (objectIn instanceof XapiCollectionObject) {
            Collection c = (Collection) objectIn.getUserObject();
            try {
                if (c.getName().equals("db") 
                        && c.getParentCollection() == null) {
                    this.setEnabled(false);
                } else {
                    this.setEnabled(true);
                }
            } catch (XMLDBException e) {
                e.printStackTrace(Application.err);
            }
        } else {
            this.setEnabled(true);
        }
    }

    /**
     * <Some description here>
     * 
     * @param e
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
        
        NewXMLResourceDialog dialog = new NewXMLResourceDialog();
        dialog.setVisible(true);
    }

}
