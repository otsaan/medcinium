/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Listeners;

import models.Rappel;

/**
 *
 * @author zianwar
 */
public interface RappelListener {
    public void onRappelCreated(Rappel rappel);
    public void onRappelUpdated(Rappel rappel);
    public void onRappelDeleted(Rappel rappel);
}
