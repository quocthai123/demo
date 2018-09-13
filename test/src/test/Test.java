/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;

/**
 *
 * @author ADMIN
 */
public class Test implements DropTargetListener {
    private DropTarget dt;
    private JTable jtable;
    private DefaultTableModel TableModel = new DefaultTableModel();
    public Test (JTable jtable)
    {
        this.jtable = jtable;
        dt =new DropTarget(jtable, this);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        try{
            if((dtde.getDropAction() == DnDConstants.ACTION_MOVE) ||
                    (dtde.getDropAction() == DnDConstants.ACTION_COPY) ||
                    (dtde.getDropAction() == DnDConstants.ACTION_LINK) ||
                    (dtde.getDropAction() == DnDConstants.ACTION_COPY_OR_MOVE) ||
                    (dtde.getDropAction() == DnDConstants.ACTION_NONE) ||
                    (dtde.getDropAction() == DnDConstants.ACTION_REFERENCE))
            {
                Transferable tr =dtde.getTransferable();
                DataFlavor[] flavors = tr.getTransferDataFlavors();
                if(flavors.length >0)
                {
                    if(flavors[0].isFlavorJavaFileListType())
                    {
                        dtde.acceptDrop(DnDConstants.ACTION_COPY);
                        
                            java.util.List list =  (java.util.List) tr.getTransferData(flavors[0]);
                        
                    }
                }
            }
        }}
}
