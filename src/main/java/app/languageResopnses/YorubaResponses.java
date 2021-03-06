package app.languageResopnses;

import app.controller.SMSController;
import app.models.Country;
import app.utilities.COVIDTest;
import app.utilities.LocalTranslation;
import app.utilities.ResponseFormatter;

import static app.interfaces.MessageInterface.*;
import static app.interfaces.ResponseInterface.*;

public class YorubaResponses {


    private static YorubaResponses instance;
    private final COVIDTest covidTest = new COVIDTest();

    // required private constructor
    private YorubaResponses() {

    }

    // lazy initialization
    public static YorubaResponses getInstance() {
        if(instance == null){
            instance = new YorubaResponses();
        }
        return instance;
    }




    public String getResponse(String request) {

        String response = "";

        switch (request) {

            case "3":

                response = CON + " " + ResponseFormatter.getFormat(LocalTranslation.getTranslate(SELECT_AN_OPTION, ISO_YORUBA));
                break;

            case "3*1":

                response = END + " " + ResponseFormatter.getFormat(LocalTranslation.getTranslate(Country.getCountryInfo(), ISO_YORUBA));
                break;

            case "3*2":

                response = END + " " + LocalTranslation.getTranslate(PROTECT_YOURSELF, ISO_YORUBA);
                SMSController.sms(LocalTranslation.getTranslate(PROTECT_YOURSELF_MESSAGE, ISO_YORUBA));
                break;

            case "3*3":

                response = END + " " + LocalTranslation.getTranslate(SYMPTOMS, ISO_YORUBA);
                SMSController.sms(LocalTranslation.getTranslate(SYMPTOMS_MESSAGE, ISO_YORUBA));
                break;

            case "3*4":
                response = CON + " " + LocalTranslation.getTranslate(TELL_A_FRIEND, ISO_YORUBA);
                break;

        }

        if (request.length() > 2 && request.charAt(2) == '5')
            response = covidTest.takeTest(request, ISO_YORUBA);


        return response;
    }


}
