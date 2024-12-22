package br.com.juhmaran.cleancode.comments;

import jdk.internal.icu.text.UnicodeSet;

import java.net.SocketException;

public class NoisyComments {

    private final UnicodeSet response;

    public NoisyComments(UnicodeSet response) {
        this.response = response;
    }

    private void startSending() throws SocketException {
        try {
            doSending();
        } catch (Exception e) {
            addExceptionAndCloseResponse(e);
        }
//        catch (Exception e) {
//            try {
//                response.add(ErrorResponder.makeExceptionString(e));
//                response.closeAll();
//            } catch (Exception e1) {
//                // Give me a break!
//            }
//        }
    }

    private void addExceptionAndCloseResponse(Exception e) {
        try {
            response.add(ErrorResponder.makeExceptionString(e));
//            response.closeAll();
        } catch (Exception e1) {
            // retornar mensagem de erro
        }
    }

    private void doSending() {
    }

    public static class ErrorResponder {
        public static int makeExceptionString(Exception e) {
            return 0;
        }
    }

}
