package com.app.AylluKuyuy.modelos;

public class Plan_Personalizado {

    private int idPlan;
    private int idfamilia;
    private String plan;

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public int getIdfamilia() {
        return idfamilia;
    }

    public void setIdfamilia(int idfamilia) {
        this.idfamilia = idfamilia;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public Plan_Personalizado(int idPlan, int idfamilia, String plan) {
        this.idPlan = idPlan;
        this.idfamilia = idfamilia;
        this.plan = plan;
    }
}
