package notepad.controller;

import notepad.model.Document;
import notepad.view.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.*;

import javax.swing.JFileChooser;

import by.bsuir.ppvis.utls.ChildMenus;
import by.bsuir.ppvis.utls.KeyChar;
import by.bsuir.ppvis.utls.SelectionMode;

public class Controller {
	
	private static Document doc;
	private static Carret carret;
	private static TextView textView;
	private static SelectionMode selectMode = SelectionMode.OFF;
	private static String currentFileName = null;
		
	public static ActionListener getListener(TextView textView, ChildMenus menu){
		if(menu == ChildMenus.NEW){
			return new NewEvent(textView);
		} else if(menu == ChildMenus.OPEN){
			return new OpenEvent(textView);
		} else if(menu == ChildMenus.SAVE){
			return new SaveEvent(textView);
		} else if(menu == ChildMenus.SAVEAS){
			return new SaveasEvent(textView);
		} else if(menu == ChildMenus.EXIT){
			return new ExitEvent(textView);
		} else if(menu == ChildMenus.COPY){
			return new CopyEvent(textView);
		} else if(menu == ChildMenus.CUT){
			return new CutEvent(textView);
		} else if(menu == ChildMenus.PASTE){
			return new PasteEvent(textView);
		} else if(menu == ChildMenus.ABOUT){
			return new AboutEvent();
		}
		return null;
	}
	
	public static class NewEvent implements ActionListener {
		private TextView textView;
		
		public NewEvent(TextView tv){
			textView = tv;
		}
		
		public void actionPerformed(ActionEvent event){
			if(!doc.isEmpty()){
				(new SaveEvent(textView)).actionPerformed(event);
			}
			Document doc = textView.getDocument();
			Carret carret = textView.getCarret();
			doc.setModel("");
			currentFileName = null;
			carret.setPos(0);
			textView.repaint();
		}
	}
	
	public static class OpenEvent implements ActionListener {
		private TextView textView;
		
		public OpenEvent(TextView tv){
			textView = tv;
		}
		
		public void actionPerformed(ActionEvent event){
			JFileChooser dialog = new JFileChooser();
			if(dialog.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
				File file = dialog.getSelectedFile();
				currentFileName = file.getAbsolutePath();
				
				try {
					BufferedReader buf = new BufferedReader(new FileReader(currentFileName));
					String fileContent = "", s = "";
					while((s = buf.readLine())!=null){
						fileContent+=s+'\n';
					}
					buf.close();
					textView.getDocument().setModel(fileContent);
					textView.repaint();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class SaveEvent implements ActionListener {
		private TextView textView;
		
		public SaveEvent(TextView tv){
			textView = tv;
		}
		
		public void actionPerformed(ActionEvent event){
			if(currentFileName==null){
				saveEventWhenFileNotDefined();
			} else {
				saveEventWhenFileDefined();
			}
		}
	}
	
	public static class SaveasEvent implements ActionListener {
		private TextView textView;
		
		public SaveasEvent(TextView tv){
			textView = tv;
		}
		
		public void actionPerformed(ActionEvent event){
			saveEventWhenFileNotDefined();
		}
	}
	
	static void saveEventWhenFileDefined(){
		try {
			FileWriter writer = new FileWriter(currentFileName);
			String tempModelForFile = textView.getDocument().getModel();
			tempModelForFile = tempModelForFile.replace("\n", "\r\n");
			writer.write(tempModelForFile);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void saveEventWhenFileNotDefined(){
		JFileChooser dialog = new JFileChooser();
		if(dialog.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
			File file = dialog.getSelectedFile();
			currentFileName = file.getAbsolutePath();
			
			try {
				FileWriter writer = new FileWriter(file);
				String tempModelForFile = textView.getDocument().getModel();
				tempModelForFile = tempModelForFile.replace("\n", "\r\n");
				writer.write(tempModelForFile);
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class ExitEvent implements ActionListener {
		private TextView textView;
			
		public ExitEvent(TextView tv){
			textView = tv;
		}
		
		public void actionPerformed(ActionEvent event){
			textView.parent().setVisible(false);
			textView.parent().dispose();
		}
	}
	
	public static class PasteEvent implements ActionListener {
		private TextView textView;
		
		public PasteEvent(TextView tv){
			textView = tv;
		}
		
		public void actionPerformed(ActionEvent event){
			String clipboardText;
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();	
			Transferable trans = clipboard.getContents(this);
			if(trans!=null&&trans.isDataFlavorSupported(DataFlavor.stringFlavor)){
				try {
					clipboardText = (String)trans.getTransferData(DataFlavor.stringFlavor);
					textView.getDocument().insert(textView.getCarretPos(), clipboardText);
					textView.repaint();
				} catch (UnsupportedFlavorException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			textView.setPreferredSize(new Dimension(doc.getMaxWidth(), doc.getMaxHeight()));
			textView.revalidate();
				
			
		}
	}
	public static class CopyEvent implements ActionListener {
		private TextView textView;
		
		public CopyEvent(TextView tv){
			textView = tv;
		}
		
		public void actionPerformed(ActionEvent event){
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();	
			Document doc = textView.getDocument();
			StringSelection textForClipboard = 
							new StringSelection(doc.getSelectedText());
			clipboard.setContents(textForClipboard, null);
			textView.repaint();
						
		}
	}
	
	public static class CutEvent implements ActionListener {
		private TextView textView;
		
		public CutEvent(TextView tv){
			textView = tv;
		}
		
		public void actionPerformed(ActionEvent event){
			Document doc = textView.getDocument();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();	
			String subString = doc.cutSubString();
			StringSelection textForClipboard = 
							new StringSelection(subString);
			clipboard.setContents(textForClipboard, null);
			carret.setPos(carret.getPos()-subString.length());
			
			textView.setPreferredSize(new Dimension(doc.getMaxWidth(), doc.getMaxHeight()));
			textView.revalidate();
			textView.repaint();
						
		}
	}
	
	public static class AboutEvent implements ActionListener {
		public void actionPerformed(ActionEvent event){
			AboutBox about;
			try {
				about = new AboutBox();
				about.setVisible(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public static class MyMouseAdapter extends MouseAdapter{
		public MyMouseAdapter(TextView tv){
			textView = tv;
			doc = tv.getDocument();
			carret = tv.getCarret();
		}
		
		public void mousePressed(MouseEvent event){
			
			if(event.getButton()==MouseEvent.BUTTON1&&!doc.isEmpty()){
				selectMode = SelectionMode.ON;
				doc.setBegSelectPos(carret.getPosByCoords(event.getX(), event.getY()));				
			}
			
		}
		
		public void mouseClicked(MouseEvent event){
			textView.requestFocus();
			carret.setPos(carret.getPosByCoords(event.getX(), event.getY()));
		}
		
		public void mouseReleased(MouseEvent event){
			if(event.getButton()==MouseEvent.BUTTON1&&!doc.isEmpty()){
				doc.setEndSelectPos(carret.getPosByCoords(event.getX(), event.getY()));
				textView.repaint();
				selectMode = SelectionMode.OFF;
			}
		}
		
		public void mouseDragged(MouseEvent event){
			
		}
	}
	
	public static class MyMouseMotion implements MouseMotionListener{
		
		public MyMouseMotion(TextView tv){
			textView = tv;
			doc = tv.getDocument();
			carret = tv.getCarret();
		}
		
		public void mouseMoved(MouseEvent event){
			
			 while(event.getModifiers()==MouseEvent.MOUSE_PRESSED) { 
				 	System.out.print("+");
				 	doc.setEndSelectPos(carret.getPosByCoords(event.getX(), event.getY()));
					textView.repaint();
		        }
						
		}
		
		public void mouseDragged(MouseEvent event){
			
		}
	}
	
	
	public static class KeyListen implements KeyListener {
		
		public KeyListen(TextView tv){
			textView = tv;
			doc = textView.getDocument();
			carret = textView.getCarret();
		}
		
		public void keyPressed(KeyEvent event){

			    switch (event.getKeyCode()) {
				    case KeyEvent.VK_ENTER: {
						EnterAction();
						break;
				    }
				    case KeyEvent.VK_BACK_SPACE: {
						BackspaceAction();
						break;
				    }
				    case KeyEvent.VK_TAB: {
						doc.append('\t');
						break;
				    }
				    case KeyEvent.VK_LEFT: {
				    	checkShift(event);
						if (carret.getPos() - 1 >= 0)
						    carret.dec();
						checkSelection();
					break;
				    }
				    case KeyEvent.VK_RIGHT: {
				    	checkShift(event);
						if (carret.getPos() + 1 <= doc.getModel().length())
							carret.inc();
						checkSelection();
						break;
				    }
				    case KeyEvent.VK_UP: {
				    	checkShift(event);	
						if (carret.getLineNumber() > 1) {
						    carret.moveUp();
						}
						checkSelection();
						break;
				    }
	
				    case KeyEvent.VK_DOWN: {
				    	checkShift(event);
						if (carret.getLineNumber() < doc.getLineCount()) {
						    carret.moveDown();
						}
						checkSelection();
						break;
				    }
				    case KeyEvent.VK_SHIFT: {
				    	break;
				    }
				    case KeyEvent.VK_CONTROL: {
				    	break;
				    }
				    case KeyEvent.VK_ALT: {
				    	break;
				    }
				    case KeyEvent.VK_CAPS_LOCK: {
				    	break;
				    }
				    default: {
				    	checkSelection();
				    	DefaultAction(event);
				    }
			    }
			    
			    textView.setPreferredSize(new Dimension(doc.getMaxWidth(),doc.getMaxHeight()));
			    textView.revalidate();
			    textView.repaint();
		}
		
		public void keyReleased(KeyEvent event){
			
		}
		
		public void keyTyped(KeyEvent event){
			
		}
	}
	
	public static void checkShift(KeyEvent event){
		if (event.isShiftDown() && selectMode == SelectionMode.OFF) {
			selectMode = SelectionMode.ON;
			doc.setBegSelectPos(carret.getPos());
	    } else if(!event.isShiftDown()) selectMode = SelectionMode.OFF;
	}
	
	public static void EnterAction(){
		selectMode = SelectionMode.OFF;
		doc.insert(carret.getPos(), String.valueOf(KeyChar.NEWLINE));
		carret.inc();
	}
	
	public static void BackspaceAction(){
		selectMode = SelectionMode.OFF;
		doc.erasePrevChar(carret.getPos());
		carret.dec();
	}
	
	public static void DefaultAction(KeyEvent e){
		selectMode = SelectionMode.OFF;
		doc.insert(carret.getPos(), String.valueOf(e.getKeyChar()));
		carret.inc();

	}
	
	private static void checkSelection(){
		if(selectMode==SelectionMode.ON){
			doc.setEndSelectPos(carret.getPos());
		} else {
			doc.setBegSelectPos(-1);
			doc.setEndSelectPos(-1);
		}
	}
}
