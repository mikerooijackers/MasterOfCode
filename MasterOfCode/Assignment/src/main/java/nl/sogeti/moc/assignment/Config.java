/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.sogeti.moc.assignment;

import com.mycompany.annotations.AssignCreator;
import com.mycompany.annotations.AssignInformation;
import com.mycompany.annotations.Hint;
import com.mycompany.annotations.Hints;

/**
 *
 * @author JordiK
 */
@AssignCreator(
        creatorName = "Fill in creator name here",
        creatorOrginisation = "Orginisation here",
        creatorWebsite = "Website here",
        creatorLogo = "Logo url here"
)
@AssignInformation (
        name = "Assignment name here",
        contestantDescription = "Description for contestants here",
        spectatorDescription = "Description for contestants here",
        difficulty = "Easy/Medium/Hard"
)
@Hints (
        value = {@Hint(delay = 50, description = "Enter hint here"), @Hint(delay = 100, description = "Enter hint here")}
)
public abstract class Config {}
