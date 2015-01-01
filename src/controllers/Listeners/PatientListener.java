/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Listeners;

import models.Patient;

/**
 *
 * @author zianwar
 */
public interface PatientListener {
    public void onPatientCreated(Patient patient);
    public void onPatientUpdated(Patient patient);
    public void onPatientDeleted(Patient patient);
}
