package modelo;

public class Crecimiento 
{
    private int crePv;
    private int creFue;
    private int creHab;
    private int creVel;
    private int creSue;
    private int creDef;
    private int creRes;

    public Crecimiento() 
    {
        this.crePv = 0;
        this.creFue = 0;
        this.creHab = 0;
        this.creVel = 0;
        this.creSue = 0;
        this.creDef = 0;
        this.creRes = 0;
    }

    public int getCrePv() { return crePv; }
    public void setCrePv(int crePv) { this.crePv = crePv; }

    public int getCreFue() { return creFue; }
    public void setCreFue(int creFue) { this.creFue = creFue; }

    public int getCreHab() { return creHab; }
    public void setCreHab(int creHab) { this.creHab = creHab; }

    public int getCreVel() { return creVel; }
    public void setCreVel(int creVel) { this.creVel = creVel; }

    public int getCreSue() { return creSue; }
    public void setCreSue(int creSue) { this.creSue = creSue; }

    public int getCreDef() { return creDef; }
    public void setCreDef(int creDef) { this.creDef = creDef; }

    public int getCreRes() { return creRes; }
    public void setCreRes(int creRes) { this.creRes = creRes; }
}
