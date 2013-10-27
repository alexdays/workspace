package by.bsuir.ppvis.calculator.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import by.bsuir.ppvis.calculator.controller.Controller;
import by.bsuir.ppvis.calculator.controller.NextStepEvent;
import by.bsuir.ppvis.calculator.controller.PrevStepEvent;
import by.bsuir.ppvis.calculator.utls.AdditionalOperEnum;
import by.bsuir.ppvis.calculator.utls.BottomOperEnum;
import by.bsuir.ppvis.calculator.utls.CenterOperEnum;
import by.bsuir.ppvis.calculator.utls.CreateMenu;
import by.bsuir.ppvis.calculator.utls.MainMenuEnum;
import by.bsuir.ppvis.calculator.utls.TopOperEnum;
import by.bsuir.ppvis.calculator.parse.GeneralParse;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.tree.TreePath;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class CalcFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_FRAME_WIDTH = 550;
	private static final int DEFAULT_FRAME_HEIGHT = 360;
	private static final int DEFAULT_PANEL_WIDTH = 330;
	private static final int DEFAULT_PANEL_HEIGHT = 300;
	private static final int DEFAULT_PANELLINE_HEIGHT = 50;
	private static final String DEFAULT_TITLE = "Calculator";
	private JMenuBar menuBar;
	private JTree treeView;
	private JTextField inField;
	private JPanel workPanel;
	private Controller controller;
	private JButton prevStep;
	private JButton nextStep;
	private GeneralParse genParser;
	private List<Tree> treeList;
	private int currentIndex = 0;
	private String xArg = null;
	private double result;
	public CalcFrame() {
		controller = new Controller(this);
		genParser = new GeneralParse(this);
		initCommonSettings();
		initMenuBar();
		initTree();
		initWorkingArea();
	}

	private void initCommonSettings() {
		setLayout(new BorderLayout());
		setSize(new Dimension(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT));
		setTitle(DEFAULT_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void initMenuBar() {
		menuBar = new JMenuBar();
		for(MainMenuEnum m : MainMenuEnum.values()){
			menuBar.add(CreateMenu.createMenu(m, controller));
		}
		setJMenuBar(menuBar);
	}

	private void initTree() {
		JPanel treePanel = new JPanel(new BorderLayout());
		JPanel stepBtnPanel = new JPanel(new FlowLayout());
		initStepBtn();
		treePanel.setPreferredSize(new Dimension(200, 200));
		treeView = new JTree(new Object[0]);
		treeView.setFont(new Font("Verdana", Font.BOLD, 12));
		treeView.setScrollsOnExpand(true);
		JScrollPane treeScrollPane = new JScrollPane(treeView);
		treeScrollPane.setAutoscrolls(true);
		treePanel.add(treeScrollPane, BorderLayout.CENTER);
		stepBtnPanel.add(prevStep);
		stepBtnPanel.add(nextStep);
		treePanel.add(stepBtnPanel, BorderLayout.SOUTH);
		add(treePanel, BorderLayout.WEST);		
	}
	
	private void initStepBtn(){
		prevStep = new JButton("<<");
		prevStep.addActionListener(new PrevStepEvent(this));
		nextStep = new JButton(">>");
		nextStep.addActionListener(new NextStepEvent(this));
	}

	private void initWorkingArea() {
		JPanel mainPanel, topOperPanel, centerOperPanel, 
		bottomOperPanel, additionalOperPanel, topPanel;
		mainPanel = new JPanel(new BorderLayout());
		topOperPanel = new JPanel(new GridLayout(1, 3));
		centerOperPanel = new JPanel(new GridLayout(3, 4));
		bottomOperPanel = new JPanel(new GridLayout(1, 3));
		additionalOperPanel = new JPanel(new GridLayout(1,4));
		topPanel = new JPanel(new BorderLayout());
		workPanel = new JPanel(new FlowLayout());
		initPanelSize(mainPanel, topOperPanel, 
				centerOperPanel,bottomOperPanel,additionalOperPanel);
		inField = new JTextField();
		inField.setEditable(false);
		inField.setHorizontalAlignment(JTextField.RIGHT);
		inField.setPreferredSize(new Dimension(DEFAULT_PANEL_WIDTH, 40));
		topPanel.add(inField, BorderLayout.NORTH);
		layoutingPanels(mainPanel, topOperPanel, workPanel,
				centerOperPanel,bottomOperPanel,additionalOperPanel, topPanel);
	}
		
	private void layoutingPanels(JPanel mainPanel, JPanel topOperPanel, JPanel workPanel, 
			JPanel centerOperPanel, JPanel bottomOperPanel, JPanel additionalOperPanel, JPanel topPanel)
	{
		initTopOper(topOperPanel);
		topPanel.add(topOperPanel, BorderLayout.CENTER);
		mainPanel.add(topPanel, BorderLayout.NORTH);
		initCenterOper(centerOperPanel);
		mainPanel.add(centerOperPanel, BorderLayout.CENTER);
		initBottomOper(bottomOperPanel);
		mainPanel.add(bottomOperPanel, BorderLayout.SOUTH);
		initAdditionalOper(additionalOperPanel);
		workPanel.add(mainPanel, BorderLayout.CENTER);
		workPanel.add(additionalOperPanel, BorderLayout.EAST);
		add(workPanel, BorderLayout.CENTER);
	}
	
	private void initPanelSize(JPanel mainPanel, JPanel topOperPanel, 
			JPanel centerOperPanel, JPanel bottomOperPanel, JPanel additionalOperPanel)
	{
		mainPanel.setPreferredSize(new Dimension(DEFAULT_PANEL_WIDTH,
				DEFAULT_PANEL_HEIGHT));
		topOperPanel.setPreferredSize(new Dimension(DEFAULT_PANEL_WIDTH,
				DEFAULT_PANELLINE_HEIGHT));
		centerOperPanel.setPreferredSize(new Dimension(DEFAULT_PANEL_WIDTH,
				DEFAULT_PANELLINE_HEIGHT * 3));
		bottomOperPanel.setPreferredSize(new Dimension(DEFAULT_PANEL_WIDTH,
				DEFAULT_PANELLINE_HEIGHT));
		additionalOperPanel.setPreferredSize(new Dimension(DEFAULT_PANEL_WIDTH,
				DEFAULT_PANELLINE_HEIGHT));
	}
	
	private void initAdditionalOper(JPanel panel){
		for (AdditionalOperEnum b : AdditionalOperEnum.values()) {
			JButton currentBtn = new JButton(b.getLabel());
			currentBtn.addActionListener(controller.getListener(b));
			panel.add(currentBtn);
		}
	}
	private void initTopOper(JPanel panel){
		for (TopOperEnum t : TopOperEnum.values()) {
			JButton currentBtn = new JButton(t.getLabel());
			currentBtn.addActionListener(controller.getListener(t));
			panel.add(currentBtn);
		}
	}
	private void initCenterOper(JPanel panel){
		for (CenterOperEnum c : CenterOperEnum.values()) {
			JButton currentBtn = new JButton(c.getLabel());
			currentBtn.addActionListener(controller.getListener(c));
			panel.add(currentBtn);
		}
	}
	private void initBottomOper(JPanel panel){
		for (BottomOperEnum b : BottomOperEnum.values()) {
			JButton currentBtn = new JButton(b.getLabel());
			currentBtn.addActionListener(controller.getListener(b));
			panel.add(currentBtn);
		}
	}

	public JTree getTreeView() {
		return treeView;
	}

	public void setTreeView(JTree treeView) {
		this.treeView = treeView;
	}

	public JTextField getInField() {
		return inField;
	}
	public void setDefaultView(){
		setSize(new Dimension(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT));
	}
	public void setIngenerView(){
		setSize(new Dimension(DEFAULT_FRAME_WIDTH, DEFAULT_FRAME_HEIGHT+55));
	}

	public GeneralParse getGenParser() {
		return genParser;
	}

	public List<Tree> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<Tree> stepList) {
		this.treeList = stepList;
	}

	public int getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	public String getxArg() {
		return xArg;
	}

	public void setxArg(String xArg) {
		this.xArg = xArg;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	public boolean isOperation(char key){
		return key == '+' || key == '-' || key == '*' ||
			   key == '/' || key == '^' || key == '%';
	} 
	public void expandAll(JTree tree) {
	    CommonTree root = (CommonTree) tree.getModel().getRoot();
	    expandAll(tree, new TreePath(root));
	  }

	  private void expandAll(JTree tree, TreePath parent) {
	    CommonTree node = (CommonTree) parent.getLastPathComponent();
	    if (node.getChildCount() >= 0) {
	      for (int i=0;i<node.getChildCount();i++) {
	    	CommonTree n = (CommonTree) node.getChild(i);
	        TreePath path = parent.pathByAddingChild(n);
	        expandAll(tree, path);
	      }
	    }
	    tree.expandPath(parent);
	    // tree.collapsePath(parent);
	  }
	}

	
