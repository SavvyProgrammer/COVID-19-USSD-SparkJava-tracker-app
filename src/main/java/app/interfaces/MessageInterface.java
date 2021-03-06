package app.interfaces;

import app.controller.SMSController;
import app.request.USSDRequest;
import app.utilities.LocalTranslation;

import static app.interfaces.ResponseInterface.*;

public interface MessageInterface {

    String PROTECT_YOURSELF_MESSAGE = "Wash hands with soap and water. "
            + "Cover your mouth and nose with your bent elbow or tissue when you cough or sneeze. Dispose of the used tissue immediately. "
            + "Avoid touching your eyes, nose, and mouth with unwashed hands. "
            + "Maintain at least 1 and half metres (5 feet) distance between yourself and anyone who is coughing or sneezing. "
            + "If you have travelled recently to a country with COVID-19 outbreak in the last 14 days and you have a fever, cough, or breathing difficulty call NCDC at 080097000010. "
            + "Avoid contact with people if you have travelled recently to a country with COVID-19 outbreak in the last 14 days.";

    String SYMPTOMS_MESSAGE = "Dry cough, " +
            "sore throat, " +
            "cold, " +
            "fatigue, " +
            "difficulty breathing, " +
            "Diarrhea, " +
            "Body aches, " +
            "Fatigue, " +
            "Fever (37.8C and above), " +
            "if you have all of these symptoms, please call these toll-free lines that have been activated by Edo State Government for assistance: 08001235111 or 08002200110";


    String PROTECT_YOURSELF = "You will receive a message shortly that explains how to protect yourself from Coronavirus";


    String SYMPTOMS = "You will receive a message shortly";


    String CODE = "+234";

    static String sendMessageToFriend(String lang, String phone) {


        switch (lang) {

            case ISO_ENGLISH:
                USSDRequest.setPhoneNumber(CODE + phone);
                SMSController.sms(PROTECT_YOURSELF_MESSAGE);
                return END + " " + THANK_YOU;


            case ISO_HAUSA:
                USSDRequest.setPhoneNumber(CODE + phone);
                SMSController.sms(LocalTranslation.getTranslate(PROTECT_YOURSELF_MESSAGE, ISO_HAUSA));
                return END + " " + LocalTranslation.getTranslate(THANK_YOU, ISO_HAUSA);


            case ISO_YORUBA:
                USSDRequest.setPhoneNumber(CODE + phone);
                SMSController.sms(LocalTranslation.getTranslate(PROTECT_YOURSELF_MESSAGE, ISO_YORUBA));
                return END + " " + LocalTranslation.getTranslate(THANK_YOU, ISO_YORUBA);


            case ISO_IGBO:
                USSDRequest.setPhoneNumber(CODE + phone);
                SMSController.sms(LocalTranslation.getTranslate(PROTECT_YOURSELF_MESSAGE, ISO_IGBO));
                return  END + " " + LocalTranslation.getTranslate(THANK_YOU, ISO_IGBO);


            default:
                return END + " " + THANK_YOU;
        }


    }

}
