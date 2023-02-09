import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class myclass implements ActionListener {

    JFrame frame = new JFrame();
    JButton start = new JButton("START");
    JButton reset = new JButton("RESET");
    JLabel time = new JLabel();
    JLabel title = new JLabel("STOP WATCH");
    int elapsedtime = 0;
    int sec =0;
    int min =0;
    int hrs = 0;
    boolean started = false;
    String secstring = String.format("%02d",sec);
    String minstring = String.format("%02d",min);
    String hrsstring = String.format("%02d",hrs);

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedtime+=1000;
            hrs = elapsedtime/3600000;
            min = (elapsedtime/60000)%60;
            sec = (elapsedtime/1000)%60;
             secstring = String.format("%02d",sec);
             minstring = String.format("%02d",min);
             hrsstring = String.format("%02d",hrs);
             time.setText(hrsstring+":"+minstring+":"+secstring);

        }
    });

    myclass(){

        title.setBounds(100,30,250,50);
        title.setFont(new Font("MV Boli",Font.PLAIN,28));
        title.setHorizontalAlignment(JTextField.CENTER);


        time.setText(hrsstring+":"+minstring+":"+secstring);
        time.setBounds(100,100,250,100);
        time.setFont(new Font("MV Boli",Font.PLAIN,35));
        time.setBorder(BorderFactory.createBevelBorder(1));
        time.setOpaque(true);
        time.setHorizontalAlignment(JTextField.CENTER);

        start.setBounds(100,200,125,50);
        start.setFont(new Font("INK Free",Font.PLAIN,25));
        start.setFocusable(false);
        start.addActionListener(this);

        reset.setBounds(225,200,125,50);
        reset.setFont(new Font("INK Free",Font.PLAIN,25));
        reset.setFocusable(false);
        reset.addActionListener(this);

        frame.add(title);
        frame.add(start);
        frame.add(reset);
        frame.add(time);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,420);
        frame.setLayout(null);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==start){

            if(started==false){
                started=true;
                start.setText("STOP");
                start();
            } else{
                started=false;
                start.setText("START");
                stop();
            }
        }
        if (e.getSource()==reset){
            started=false;
            start.setText("START");
            restart();
        }

    }

    void start(){
        timer.start();

    }

    void stop(){
        timer.stop();

    }

    void restart(){
        timer.stop();
        elapsedtime=0;
        sec=0;
        min=0;
        hrs=0;
        secstring = String.format("%02d",sec);
        minstring = String.format("%02d",min);
        hrsstring = String.format("%02d",hrs);
        time.setText(hrsstring+":"+minstring+":"+secstring);

    }
}
