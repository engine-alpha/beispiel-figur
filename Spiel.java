import ea.*;

/**
 * Diese Klasse demonstriert die einfache Nutzung einer Figur - inklusive 
 * ihrer wichtigsten Modifikations-Arten.<br /><br />
 * 
 * Notiz:<br />
 * Die hier zugehoerige Figur-Datei (.eaf-Format) befindet sich im Projektordner.<br />
 * <b>Eigene Figuren</b> lassen sich mit der Software <i>Figureneditor</i> erstellen. Diese 
 * ist bereits im Entwicklerkit enthalten <b>oder</b> laesst sich explizit von der EA-Website
 * (<code>www.engine-alpha.org</code>) herunterladen.<br /><br />
 * 
 * Die Klasse Figur kann noch ein bisschen mehr. Um <b>alles</b> zu sehen, muss die Dokumentation 
 * eingesehen werden.
 * 
 * @version 2.0
 * @author Michael Andonie
 */
public class Spiel
extends Game {
    
    /**
     * Die Figur.
     */
    private Figur figur;
    
    /**
     * Konstruktor-Methode.<br />
     * Laedt die Figur und macht sie sichtbar. <b>Alles andere</b> wird ueber die zusaetzlichen Methoden 
     * ermoeglicht.
     */
    public Spiel() {
        super(500, 400, "Figur-Beispiel");
        
        //Erstelle die Figur:
        //X-Koordinate der linken oberen Ecke: 100
        //Y-Koordinate der linken oberen Ecke: 50
        //Pfad der Datei im Projektordner: "rakete.eaf"
        figur = new Figur(100, 50, "rakete.eaf");
        
        //Sichtbar machen durch Anmelden an der Wurzel
        wurzel.add(figur);
    }
    
    /**
     * Diese Methode setzt den Groessenfaktor der Figur neu.
     * @param   faktor  Die gewuenschte Laenge eines Unterquadrates in Pixel
     */
    public void figurfaktorSetzen(int faktor) {
        //Den neuen Faktor auf die Figur uebertragen
        figur.faktorSetzen(faktor);
    }
    
    /**
     * Setzt die Animationsgeschwindigkeit der Figur neu.
     * @param   intervall   Die Ziet <b>in Millisekunden</b>, die verstreicht, bis die Figur erneut 
     * ihr aktuelles Animations-Bild wechselt.
     */
    public void figuranimationsGeschwindigkeitSetzen(int intervall) {
        figur.animationsGeschwindigkeitSetzen(intervall);
    }
    
    /**
     * Setzt ob die Figur entlang der senkrechten Mittellinie (<b>also parallel zu einer Y-Achse</b>)
     * gespiegelt werden soll.
     * @param   spiegel Ist dieser Wert <code>true</code>, so wird die Figur senkrecht gespiegelt von ihrem 
     * Ausgangszustand her dargestellt. Ist der Wert <code>false</code>, so ist dies nicht der Fall.
     */
    public void figurspiegelYSetzen(boolean spiegel) {
        //Den Wert auf die Figur uebertragen
        figur.spiegelYSetzen(spiegel);
    }
    
    /**
     * Setzt ob die Figur entlang der waagrecht Mittellinie (<b>also parallel zu einer X-Achse</b>)
     * gespiegelt werden soll.
     * @param   spiegel Ist dieser Wert <code>true</code>, so wird die Figur waagrecht gespiegelt von ihrem 
     * Ausgangszustand her dargestellt. Ist der Wert <code>false</code>, so ist dies nicht der Fall.
     */
    public void figurspiegelXSetzen(boolean spiegel) {
        //Den Wert auf die Figur uebertragen
        figur.spiegelXSetzen(spiegel);
    }
    
    /**
     * Faerbt die Figur ein.<br />
     * Das bedeutet, das saemtliche ausgefuellten Unterquadrate in einer gleichen Farbe ausgefuellt werden.
     * @param   farbe   Die Farbe, in der die Figur eingefaerbt werden soll.
     */
    public void figureinfaerben(String farbe) {
        //Die Figur mit diesem Wert einfaerben
        figur.einfaerben(farbe);
    }
    
    /**
     * Macht das Einfaerben der Figur rueckgaengig.<br />
     * <b>War die Figur nicht eingefaerbt</b>, passiert gar nichts.
     */
    public void figurzurueckFaerben() {
        //Die Methode zum Zurueck-Faerben der Figur aufrufen
        figur.zurueckFaerben();
    }
    
    /**
     * Macht die Figur heller.<br />
     * ACHTUNG: Diese Methode ist NICHT unbedingt symmetrisch zu <code>dunkler()</code>. Anders 
     * gesagt: Wenn man <code>heller()</code> und dann <code>dunkler()</code> ausfuehrt muss NICHT 
     * wieder ganz dasselbe herauskommen.
     */
    public void figurHellerMachen() {
        figur.heller();
    }
    
    /**
     * Macht die Figur dunkler.<br />
     * ACHTUNG: Diese Methode ist NICHT unbedingt symmetrisch zu <code>heller()</code>. Anders 
     * gesagt: Wenn man <code>dunkler()</code> und dann <code>heller()</code> ausfuehrt muss NICHT 
     * wieder ganz dasselbe herauskommen.
     */
    public void figurDunklerMachen() {
        figur.dunkler();
    }
    
    /**
     * Die Tasten-Reagieren-Methode. Wird bei jedem Tastendruck ausgefuehrt.<br />
     * Hierdrin wird nur ueber die Pfeiltasten die Bewegung der Figur ermoeglicht.<br />
     * Wie bei allen anderen Klassen auch, die sich aus der Klasse <code>Raum</code> ableiten, 
     * koennen Figuren mit den selben Methoden aller grafischer Objekte behandelt werden. In diesem 
     * Beispiel wird die Methode <code>verschieben(...)</code> verwendet. Was sonst ueber die Klasse 
     * <code>Raum</code> moeglich ist, ist dem Handbuch und der Dokumentation zu entnehmen.
     * @param   tastencode  Der Code laesst den Tastendruck eindeutig einer Taste zuordnen.
     */
    @Override
    public void tasteReagieren(int tastencode) {
        switch(tastencode) {
            case 26: //Pfeil rauf
                //Verschiebe die Figur um Delta-X = 0 und Delta-Y = -10
                figur.verschieben(0, -10);
                break;
            case 27: //Pfeil rechts
                //Verschiebe die Figur um Delta-X = 0 und Delta-Y = 0
                figur.verschieben(10, 0);
                break;
            case 28: //Pfeil runter
                //Verschiebe die Figur  um Delta-X = 0 und Delta-Y = 10
                figur.verschieben(0, 10);
                break;
            case 29: //Pfeil links
                //Verschiebe die Figur um Delta-X = -10 und Delta-Y = 0
                figur.verschieben(-10, 0);
                break;
        }
    }
}