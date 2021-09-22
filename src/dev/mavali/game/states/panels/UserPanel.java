package dev.mavali.game.states.panels;

import com.google.gson.Gson;

import dev.mavali.game.constant.Constants;
import dev.mavali.game.gfx.Assets;
import dev.mavali.game.entities.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

public class UserPanel extends JPanel  implements PanelEssentials {

    private Menu menu;

    private JTextField userTextField;
    private JComboBox <String> userComboBox;
    private JButton addUserButton;
    private JButton loginButton;
    private JButton removeUserButton;
    private JButton exitGameButton;
    private LinkedHashMap <String, User> userLinkedHashMap;
    static String text;


    public UserPanel(Menu menu) {
        this.menu = menu;
        setBounds(0,0, Constants.screenWidth, Constants.screenHeight);
        setLayout(null);
        init();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Assets.background_night,0,0,Constants.screenWidth,Constants.screenHeight,null);
    }

    public void init() {
       //Text Field
       userTextField = new JTextField("USER-NAME", 20);
       userTextField.setSize(200, 100);
       userTextField.setLocation(620, 100);
       userTextField.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               userTextField.setText("");
           }
       });
       //Combo Box
       userComboBox = new JComboBox<>();
       userComboBox.setSize(200, 100);
       userComboBox.setLocation(620, 300);
       //Buttons
       addUserButton = new JButton("add");
       removeUserButton = new JButton("remove");
       loginButton = new JButton("login");
       exitGameButton = new JButton("exit");
       //Linked HashMap
       userLinkedHashMap = new LinkedHashMap<String, User>();
       // Private Methods
       setComponentSize(addUserButton, removeUserButton ,exitGameButton , loginButton);
       setComponentLocation();
       addComponent();
       actionOnComponent();
       try {
           loadUser();
       } catch (IOException e) {
           e.printStackTrace();
       }


   }

    public void setComponentSize (JButton... buttons){
       for (JButton button : buttons) {
           button.setSize(160,100);
       }
   }
   public void setComponentLocation(){
        addUserButton.setLocation(200,500);
        loginButton.setLocation(620, 500);
        removeUserButton.setLocation(1040,500);
        exitGameButton.setLocation(620,750);
   }


    public void addComponent(){
        this.add(userTextField);
        this.add(userComboBox);
        this.add(addUserButton);
        this.add(removeUserButton);
        this.add(exitGameButton);
        this.add(loginButton);
   }

    public void actionOnComponent(){

        addUserButton.addActionListener(e -> {
            addUser();
        });

        loginButton.addActionListener(e -> {
            saveData();
            text = userComboBox.getItemAt(userComboBox.getSelectedIndex());
            PanelController.setPanel(menu.mainMenuPanel,menu.frame);
            menu.mainMenuPanel.repaint();
            menu.mainMenuPanel.revalidate();
        });

        removeUserButton.addActionListener(e -> {
            removeUser();
        });

        exitGameButton.addActionListener(e -> {
            saveData();
            System.exit(0);
        });

   }

   private void addUser(){
        String text = userTextField.getText();
       boolean exists = false;
       for (int index = 0; index < userComboBox.getItemCount() && !exists; index++) {
           if (text.equals(userComboBox.getItemAt(index))) {
               exists = true;
           }
       }
       if (!exists) {
           userComboBox.addItem(text);
       }
       User tempUser = new User(text);
       userLinkedHashMap.put(tempUser.name, tempUser);
       userComboBox.setSelectedItem(userComboBox.getItemAt(userComboBox.getItemCount()-1));
    }



    private void removeUser(){
        String text;
        text = userComboBox.getItemAt(userComboBox.getSelectedIndex());
        userLinkedHashMap.remove(text);
        userComboBox.removeItemAt(userComboBox.getSelectedIndex());
    }


    private void saveData(){
        Gson gson = new Gson();
        String json = gson.toJson(userLinkedHashMap);
        FileWriter fileWriter = null;
        try {
           fileWriter = new FileWriter("src/dev/mavali/game/data/game.data");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(json);
        printWriter.flush();
    }



    private void loadUser() throws IOException {
        String str;
        {// STACK OVER FLOW
            File file = new File("src/dev/mavali/game/data/game.data");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        str = new String(data, StandardCharsets.UTF_8);
        }
        Gson gson = new Gson();
        LinkedHashMap lhm = new LinkedHashMap<>();
        lhm = gson.fromJson(str, LinkedHashMap.class);
        userLinkedHashMap = lhm;
        for (String s : userLinkedHashMap.keySet()) {
            userComboBox.addItem(s);
        }
    }


}
