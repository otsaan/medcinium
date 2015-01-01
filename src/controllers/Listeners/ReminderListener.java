/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Listeners;

import models.Reminder;

/**
 *
 * @author zianwar
 */
public interface ReminderListener {
    public void onRappelCreated(Reminder rappel);
    public void onRappelUpdated(Reminder rappel);
    public void onRappelDeleted(Reminder rappel);
}
