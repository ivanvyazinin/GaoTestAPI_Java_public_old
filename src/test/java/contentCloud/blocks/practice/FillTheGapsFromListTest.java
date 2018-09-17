package test.java.contentCloud.blocks.practice;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import main.java.entities.contentCloud.blocks.practice.FillTheGapsFromList;
import main.java.steps.CommonSteps;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.SuperTest;

import static main.java.utils.Generator.getRandomText;
import static main.java.utils.Generator.getRandomTextRandomLength;

public class FillTheGapsFromListTest extends SuperTest {
    private CommonSteps steps;
    private FillTheGapsFromList fillTheGapsFromList;

    @BeforeClass
    public void prepareSteps(){
        steps = new CommonSteps();
    }

    @BeforeMethod
    public void prepareEntity(){
        fillTheGapsFromList = new FillTheGapsFromList();
    }

    @Test
    @Story("Create FillTheGapsFromList Block")
    @Description("Just create FillTheGapsFromListTest Block")
    public void createfillTheGapsFromList() {
        fillTheGapsFromList.gaps.add(new FillTheGapsFromList.Gap());
        steps.createEntity(fillTheGapsFromList);
        steps.checkStatusCode(201);
    }

    @Test
    @Story("Create FillTheGapsFromList Block")
    @Description("Cannot create FillTheGapsFromListTest Block without options")
    public void createfillTheGapsFromListWithoutOptions() {
        fillTheGapsFromList.gaps.add(new FillTheGapsFromList.Gap());
        fillTheGapsFromList.gaps.get(0).options.clear();
        steps.createEntity(fillTheGapsFromList);
        steps.checkStatusCode(400);
    }

    @Test
    @Story("Create FillTheGapsFromList Block")
    @Description("Cannot create FillTheGapsFromListTest Block with 6 options")
    public void createfillTheGapsFromListWithSixOptions() {
        fillTheGapsFromList.gaps.add(new FillTheGapsFromList.Gap());
        fillTheGapsFromList.gaps.get(0).options.add(getRandomTextRandomLength(160));
        fillTheGapsFromList.gaps.get(0).options.add(getRandomTextRandomLength(160));
        fillTheGapsFromList.gaps.get(0).options.add(getRandomTextRandomLength(160));
        fillTheGapsFromList.gaps.get(0).options.add(getRandomTextRandomLength(160));
        fillTheGapsFromList.gaps.get(0).options.add(getRandomTextRandomLength(160));
        steps.createEntity(fillTheGapsFromList);
        steps.checkStatusCode(400);
    }

    @Test
    @Story("Create FillTheGapsFromList Block")
    @Description("Cannot create FillTheGapsFromListTest Block with 161 symbol in option")
    public void createfillTheGapsFromListWithTooLongOptions() {
        fillTheGapsFromList.gaps.add(new FillTheGapsFromList.Gap());
        fillTheGapsFromList.gaps.get(0).options.add(getRandomText(161));
        steps.createEntity(fillTheGapsFromList);
        steps.checkStatusCode(400);
    }

    @Test
    @Story("Create FillTheGapsFromList Block")
    @Description("Cannot create FillTheGapsFromListTest Block with 161 symbol in right answer")
    public void createfillTheGapsFromListWithTooLongAnswer() {
        fillTheGapsFromList.gaps.add(new FillTheGapsFromList.Gap());
        fillTheGapsFromList.gaps.get(0).right_answer = getRandomText(161);
        steps.createEntity(fillTheGapsFromList);
        steps.checkStatusCode(400);
    }

}
