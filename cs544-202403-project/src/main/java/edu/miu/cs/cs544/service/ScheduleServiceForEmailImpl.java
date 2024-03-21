//package edu.miu.cs.cs544.service;
//
//import edu.miu.cs.cs544.integration.EmailService;
//import edu.miu.cs.cs544.repository.MemberRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ScheduleServiceForEmailImpl implements ScheduleServiceForEmail{
//    @Autowired
//    private MemberRepository memberRepository;
//
//    @Autowired
//    private EmailService emailService;
//
//    @Async
//    @Scheduled(cron = "0 */1 * * * *")
//public void sendLowBalanceEmails() {
//        System.out.println("Running every 1 mins check");
//        try {
//            List<String> emails = memberRepository.findMemberEmailsByLowBalance();
//            emails.forEach(email -> {
//                String message = "Your account balance is low. Please consider adding funds.";
//                emailService.sendEmail(email, "Low Account Balance", message);
//            });
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//    }
//}
