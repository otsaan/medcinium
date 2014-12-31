
package controllers;

import models.Model;
import views.View;

/**
 * This class creates and manages other controllers, It does the database connection stuff,
 * constructs the MainFrame, and displays the GUI of the app.
 * @author zianwar
 */
public class MainController {
    Model model = new Model();
    View view = new View(model);
    
    // controller sending commands to the model and view
    Controller controller = new Controller(model, view);
}
