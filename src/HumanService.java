public class HumanService {
    GoogleRegisterService grc = new GoogleRegisterService();
// етод рахування (людей і так іншу)
    long requestDuration;

    public void sendToRegistationService(Human h){

        long begin = System.currentTimeMillis();
        grc.send(h);


        long end = System.currentTimeMillis();

        long requurationestD = end - begin;
        //sendRequestDurationToAnaliticService(requurationestD);

    }
}
