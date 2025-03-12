package modelo;

public class Estadisticas 
{
    private int pv;
    private int fue;
    private int hab;
    private int vel;
    private int sue;
    private int def;
    private int res;
    private int con;
    private int mov;

    public Estadisticas(int pv, int fue, int hab, int vel, int sue, int def, int res, int con, int mov) 
    {
        this.pv = pv;
        this.fue = fue;
        this.hab = hab;
        this.vel = vel;
        this.sue = sue;
        this.def = def;
        this.res = res;
        this.con = con;
        this.mov = mov;
    }

    public int getPv() { return pv; }
    public void setPv(int pv) { this.pv = pv; }

    public int getFue() { return fue; }
    public void setFue(int fue) { this.fue = fue; }

    public int getHab() { return hab; }
    public void setHab(int hab) { this.hab = hab; }

    public int getVel() { return vel; }
    public void setVel(int vel) { this.vel = vel; }

    public int getSue() { return sue; }
    public void setSue(int sue) { this.sue = sue; }

    public int getDef() { return def; }
    public void setDef(int def) { this.def = def; }

    public int getRes() { return res; }
    public void setRes(int res) { this.res = res; }

    public int getCon() { return con; }
    public void setCon(int con) { this.con = con; }

    public int getMov() { return mov; }
    public void setMov(int mov) { this.mov = mov; }
}
