
import javax.swing.*;
import javax.swing.plaf.SliderUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class SwingComponentDemo {
    JFrame f=new JFrame("测试swing基本组件");
//生命菜单相关的组件
    JMenuBar menubar = new JMenuBar();
    JMenu fileMenue = new JMenu("文件");
    JMenu editMenue = new JMenu("编辑");

    JMenuItem auto  = new JMenuItem("自动换行");
    JMenuItem copy  = new JMenuItem("复制");
    JMenuItem paste = new JMenuItem("粘贴");

    JMenu formMenu = new JMenu("格式");
    JMenuItem comment =new JMenuItem("注释");
    JMenuItem cancelcomment =new JMenuItem("取消注释");

    //声明文本域
    JTextArea ta = new JTextArea(8,10);

    String[] colors={"红色","绿色","蓝色"};
    //声明列表框
    JList<String>colorlist = new JList<String>(colors);

    //声明选择相关组件
    JComboBox<String>colorSelect = new JComboBox<>();

    ButtonGroup bg = new ButtonGroup();
    JRadioButton male = new JRadioButton("男",false);
    JRadioButton famale = new JRadioButton("女",true);

    JCheckBox isMarried = new JCheckBox("是否已婚?",true);


    //声明底部
    JTextField tf = new JTextField(40);
    JButton ok = new JButton("确定");

    //声明右键菜单
    JPopupMenu jPopupMenu = new JPopupMenu();

    JRadioButton metal = new JRadioButton("metal风格");
    JRadioButton nimbus= new JRadioButton("nimbus风格");
    JRadioButton windows = new JRadioButton("windows风格");
    JRadioButton windowsclassic = new JRadioButton("windows经典风格");
    JRadioButton motif = new JRadioButton("motif风格");

    ButtonGroup poupButtonBg = new ButtonGroup();

    public void init(){
        //组装视图

        //组装底部
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(tf);
        bottomPanel.add(ok);
        f.add(bottomPanel, BorderLayout.SOUTH);

        //组装选择相关的组件
        JPanel selectPanel = new JPanel();

        selectPanel.add(colorSelect);
        colorSelect.addItem("红色");
        colorSelect.addItem("绿色");
        colorSelect.addItem("蓝色");
        bg.add(male);
        bg.add(famale);
        selectPanel.add(male);
        selectPanel.add(famale);
        selectPanel.add(isMarried);

        //组建文本域和相关组件
        Box topleft = Box.createHorizontalBox();
        topleft.add(ta);
        topleft.add(selectPanel);

        //组装顶部
        Box top = Box.createHorizontalBox();
        top.add(topleft);
        top.add(colorlist);

        f.add(top);

        //组装顶部的菜单
        formMenu.add(comment);
        formMenu.add(cancelcomment);

        editMenue.add(auto);
        editMenue.addSeparator();
        editMenue.add(copy);
        editMenue.add(paste);
        editMenue.addSeparator();
        editMenue.add(formMenu);

        menubar.add(fileMenue);
        menubar.add(editMenue);

        f.setJMenuBar(menubar);

        //组装右键菜单
        poupButtonBg.add(metal);
        poupButtonBg.add(nimbus);
        poupButtonBg.add(windows);
        poupButtonBg.add(windowsclassic);
        poupButtonBg.add(motif);


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //当前选择的风格
                String actionCommand = e.getActionCommand();
                try {
                    changeFlavor(actionCommand);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        };

        metal.addActionListener(listener);
        nimbus.addActionListener(listener);
        windows.addActionListener(listener);
        windowsclassic.addActionListener(listener);
        motif.addActionListener(listener);

        jPopupMenu.add(metal);
        jPopupMenu.add(nimbus);
        jPopupMenu.add(windows);
        jPopupMenu.add(windowsclassic);
        jPopupMenu.add(motif);

        ta.setComponentPopupMenu(jPopupMenu);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);



    }

    public  static void main (String[] args){
        new SwingComponentDemo().init();
    }

    private void changeFlavor(String command) throws Exception {
        try {
            switch (command) {
                case "metal风格":
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                    break;
                case "nimbus风格":
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    break;
                case "windows风格":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                case "windows经典风格":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                    break;
                case "motif风格":
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;
            }
            SwingUtilities.updateComponentTreeUI(f); // 更新整个窗口
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(f, "无法切换风格：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }






}
