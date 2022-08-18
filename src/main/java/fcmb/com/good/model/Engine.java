package fcmb.com.good.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name ="Engine")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String psn;
    private String names;
    private String lga;
    private String sex;
    private LocalDate dob;
    private LocalDate dofa;
    private LocalDate doc;
    private String gl;
    private LocalDate dopa;
    private String position;
    private String cadre;
    private String mda;
    private String hq;
    private String pl;
    private String pn;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDofa() {
        return dofa;
    }

    public void setDofa(LocalDate dofa) {
        this.dofa = dofa;
    }

    public LocalDate getDoc() {
        return doc;
    }

    public void setDoc(LocalDate doc) {
        this.doc = doc;
    }

    public String getGl() {
        return gl;
    }

    public void setGl(String gl) {
        this.gl = gl;
    }

    public LocalDate getDopa() {
        return dopa;
    }

    public void setDopa(LocalDate dopa) {
        this.dopa = dopa;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCadre() {
        return cadre;
    }

    public void setCadre(String cadre) {
        this.cadre = cadre;
    }

    public String getMda() {
        return mda;
    }

    public void setMda(String mda) {
        this.mda = mda;
    }

    public String getHq() {
        return hq;
    }

    public void setHq(String hq) {
        this.hq = hq;
    }

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }



}
