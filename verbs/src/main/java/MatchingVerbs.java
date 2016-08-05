
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by lilydiane on 8/4/16.
 *
 */
public class MatchingVerbs extends JFrame implements MouseListener {

    private static final int NUM_VERBS = 22;

    private JSplitPane splitPaneV;
    private JPanel panel1;
    private JPanel panel2;

    private ArrayList<String> list; // List of English verbs
    private JLabel verbs; // The English verb being displayed

    Random rgen = new Random();  // Random number generator
    int random; // the number generated

    private JButton clicked; // Component clicked on by user
    private String current; // text at "index" of randomly generated English verb

    private JButton sing = new JButton( "غَنَّى - يُغَنَّى - غِناء" ) ;
    private JButton die = new JButton( "ماتَ - يَمُوت - مَوْت" ) ;
    private JButton forget = new JButton( "نَسِيَ - يَنْسى - نَسْي" ) ;
    private JButton find = new JButton( "وَجَدَ - يَجِد - وُجود" ) ;
    private JButton mention = new JButton( "ذَكَرَ - يَذْكَر - ذِكْر" ) ;
    private JButton drink = new JButton( "شَرِبَ - يَشْرَب - شُرْب" ) ;
    private JButton visit = new JButton( "زارَ - يَزور - زِيَارة" ) ;
    private JButton know = new JButton( "عَرَفَ - يَعْرِف - مَعْرِفة" ) ;
    private JButton cry = new JButton( "بَكَى - يَبْكِي - بُكاء " ) ;
    private JButton fear = new JButton( "خَشِىَ - يَخْشِي - خَشْيَة" ) ;
    private JButton play = new JButton( "لَعَبَ - يَلْعَب - لَعْب" ) ;
    private JButton hear = new JButton( "سَمَعَ - يَسْمَع - سَمْع" ) ;
    private JButton be = new JButton( "كانَ - يَكون - كوْن" ) ;
    private JButton laugh = new JButton( "ضَحِكَ - يضْحَك - ضحْك" ) ;
    private JButton dance = new JButton( "رَقَصَ - يرْقُص - رَقْص" ) ;
    private JButton dream = new JButton( "حَلَمَ - يَحْلُم - حُلْم" ) ;
    private JButton say = new JButton( "قَالَ - يَقول - قالَة" ) ;
    private JButton understand = new JButton( "فَهِمَ - يَفْهَم - فَهْم" ) ;
    private JButton walk = new JButton( "مَشَىَ - يَمْشِي - مَشْي" ) ;
    private JButton wear = new JButton( "لَبِسَ - يَلْبَس - لَبْس" ) ;
    private JButton change = new JButton( "غَيَّرَ - يُغَيَّر - تَغْيِير" ) ;
    private JButton employ = new JButton( "شَغَّلَ - يُشَغَّل - تَشْغِيل" ) ;

    private String forgetEn = "to forget - he forgets - oblivion";
    private String drinkEn = "to drink - he drinks - drinking";
    private String fearEn = "to fear - he fears - fear";
    private String knowEn = "to know - he knows - knowledge";
    private String singEn = "to sing - he sings - singing";
    private String playEn = "to play - he plays - game";
    private String dieEn = "to die - he dies - death";
    private String walkEn = "to walk - he walks - walking";
    private String findEn = "to find - he finds - existence";
    private String danceEn = "to dance - he dances - dancing";
    private String mentionEn = "to mention - he mentions - memory";
    private String cryEn = "to cry - he cries - crying";
    private String understandEn = "to understand - he understands - understanding";
    private String visitEn = "to visit - he visits - visit";
    private String employEn = "to employ - he employs - employment";
    private String changeEn = "to change - he changes - change";
    private String wearEn = "to wear - he wears - ambiguity";
    private String hearEn = "to hear - he hears - hearing";
    private String dreamEn = "to dream - he dreams - dream";
    private String laughEn = "to laugh - he laughs - laughing";
    private String sayEn = "to say - he says - speech";
    private String beEn = "to be - he is - being";


    public MatchingVerbs(){
        setTitle( "Verbs" );

        JPanel topPanel = new JPanel();
        topPanel.setLayout( new BorderLayout() );
        getContentPane().add( topPanel );

        // Create the panels
        createPanel1();
        createPanel2();

        // Create a splitter pane
        splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );

        topPanel.add( splitPaneV, BorderLayout.CENTER);

        splitPaneV.add( panel1 , JSplitPane.TOP );
        splitPaneV.setRightComponent( panel2 );

    }


    public void createPanel1(){
        panel1 = new JPanel();
        panel1.setBackground(new Color(188, 225, 195));
        panel1.setPreferredSize(new Dimension(1000, 50));
        panel1.add( new JLabel( "Select the corresponding verb in Arabic: " ), BorderLayout.NORTH );

        verbs = new JLabel(" ");
        Font font = verbs.getFont().deriveFont(Font.BOLD);
        verbs.setFont(font);

        panel1.add(verbs);

        list = new ArrayList<String>();

        list.add(singEn);
        list.add(forgetEn);
        list.add(dieEn);
        list.add(findEn);
        list.add(mentionEn);
        list.add(drinkEn);
        list.add(visitEn);
        list.add(knowEn);
        list.add(cryEn);
        list.add(fearEn);
        list.add(playEn);
        list.add(hearEn);
        list.add(beEn);
        list.add(laughEn);
        list.add(danceEn);
        list.add(dreamEn);
        list.add(sayEn);
        list.add(understandEn);
        list.add(walkEn);
        list.add(wearEn);
        list.add(changeEn);
        list.add(employEn);

        generate();
    }


    public void createPanel2(){
        panel2 = new JPanel();
        panel2.setLayout( new FlowLayout() );
        panel2.setBackground(new Color(0xC9C9C9));
        panel2.setPreferredSize(new Dimension(600, 300));

        panel2.addMouseListener(this);

        panel2.add( sing );
        panel2.add( die );
        panel2.add( forget );
        panel2.add( find );
        panel2.add( mention );
        panel2.add( drink );
        panel2.add( visit );
        panel2.add( know );
        panel2.add( cry );
        panel2.add( fear );
        panel2.add( play );
        panel2.add( hear );
        panel2.add( be );
        panel2.add( laugh );
        panel2.add( dance );
        panel2.add( dream );
        panel2.add( say );
        panel2.add( understand );
        panel2.add( walk );
        panel2.add( wear );
        panel2.add( change );
        panel2.add( employ );

        sing.addMouseListener(this);
        die.addMouseListener(this);
        forget.addMouseListener(this);
        find.addMouseListener(this);
        mention.addMouseListener(this);
        drink.addMouseListener(this);
        visit.addMouseListener(this);
        know.addMouseListener(this);
        cry.addMouseListener(this);
        fear.addMouseListener(this);
        play.addMouseListener(this);
        hear.addMouseListener(this);
        be.addMouseListener(this);
        laugh.addMouseListener(this);
        dance.addMouseListener(this);
        dream.addMouseListener(this);
        say.addMouseListener(this);
        understand.addMouseListener(this);
        walk.addMouseListener(this);
        wear.addMouseListener(this);
        change.addMouseListener(this);
        employ.addMouseListener(this);
    }


    public boolean isCorrect(JButton click) {
        if (click.equals(sing)) {
            if (current.equals("to sing - he sings - singing")) {
                return true;
            } else {
                return false;
            }
        }else if (click.equals(die)) {
            if (current.equals("to die - he dies - death")) {
                panel1.setBackground(new Color(188, 225, 195));
                return true;
            } else {
                return false;
            }
        } else if (click.equals(forget)) {
            if (current.equals("to forget - he forgets - oblivion")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(find)) {
            if (current.equals("to find - he finds - existence")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(mention)) {
            if (current.equals("to mention - he mentions - memory")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(drink)) {
            if (current.equals("to drink - he drinks - drinking")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(visit)) {
            if (current.equals("to visit - he visits - visit")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(know)) {
            if (current.equals("to know - he knows - knowledge")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(cry)) {
            if (current.equals("to cry - he cries - crying")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(fear)) {
            if (current.equals("to fear - he fears - fear")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(play)) {
            if (current.equals("to play - he plays - game")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(hear)) {
            if (current.equals("to hear - he hears - hearing")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(be)) {
            if (current.equals("to be - he is - being")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(laugh)) {
            if (current.equals("to laugh - he laughs - laughing")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(dance)) {
            if (current.equals("to dance - he dances - dancing")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(dream)) {
            if (current.equals("to dream - he dreams - dream")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(say)) {
            if (current.equals("to say - he says - speech")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(understand)) {
            if (current.equals("to understand - he understands - understanding")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(walk)) {
            if (current.equals("to walk - he walks - walking")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(wear)) {
            if (current.equals("to wear - he wears - ambiguity")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(change)) {
            if (current.equals("to change - he changes - change")) {
                return true;
            } else {
                return false;
            }
        } else if (click.equals(employ)) {
            if (current.equals("to employ - he employs - employment")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public void mouseClicked(MouseEvent e) {

        clicked = (JButton) e.getSource();

//        System.out.println("t/f: " + isCorrect(clicked));

        if (isCorrect(clicked)) {
            generate();
            panel1.setBackground(new Color(188, 225, 195));
        } else {
            panel1.setBackground(new Color(247, 191, 189));
        }
    }


    public void generate() {

        random = rgen.nextInt(NUM_VERBS);

        current = list.get(random);
        verbs.setText(current);

    }


    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }


    public static void main( String args[] ){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception evt) {}

        // Create an instance of the test application

        MatchingVerbs mainFrame = new MatchingVerbs();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible( true );
    }


}
