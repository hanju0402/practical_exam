package com.practical.exam.common.sms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practical.exam.common.sms.dao.SmsDao;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Balance;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.MultipleDetailMessageSentResponse;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Service("SmsService")
public class SmsService {
	
	private final String apiKey = "NCSAVC7G9Q2SLUKL";
	private final String apiSecretKey = "ZN5YSRQK5460UDQC7KVCEYPV603HJOHS";
	private final String msgTitle="[정모해] - 정보처리기사 모의테스트\n";
	private final String fromNumber ="0808001004";
	private final DefaultMessageService messageService = NurigoApp.INSTANCE.initialize(this.apiKey, this.apiSecretKey, "https://api.coolsms.co.kr");
	
	// Cool SMS Docs = https://github.com/coolsms/coolsms-java-examples/blob/main/maven-spring-demo/src/main/java/net/nurigo/mavenspringdemo/ExampleController.java
	// https://docs.coolsms.co.kr/development-kits/java
	// 위 URL 참고 
	
	@Autowired
	SmsDao smsDao;
	/**
	 * 회원가입 인증문자 발송
	 * 번호는 반드시 01012345678 형태로 입력되어야 함
	 * @param phoneNumber
	 * @return
	 */
	public boolean postRegisterAuthMsg(String phoneNumber,String userId, String ip) {
		Map<String,String> reqData= new HashMap<String,String>();
		reqData.put("userId", userId);
		reqData.put("phone", phoneNumber);
		reqData.put("userIp", ip);

		// 당일 현재의 ip로 3회 이상 SMS 발송이 되었을 경우, 보내지 않음
		boolean ipCheck = smsDao.getSmsIpCheck(reqData);
		
		if(!ipCheck) {
			return false;
		}
		
		String randomNumber = "";
		
		Random rand = new Random();
		 for(int i=0;i<6;i++) {
            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));
            
            if(!randomNumber.contains(ran)) {
                //중복된 값이 없으면 numStr에 append
            	randomNumber += ran;
            }else {
                //생성된 난수가 중복되면 루틴을 다시 실행한다
                i-=1;
            }
        }
		String msg = this.msgTitle+"회원가입 인증번호는 ["+randomNumber+"] 입니다.";
		Message message = new Message();
        message.setFrom(this.fromNumber);
        message.setTo(phoneNumber);
        message.setText(msg);

        System.out.println(msg);
        
        SingleMessageSentResponse resp = this.sendMsg(message);
        System.out.println(resp);
        
        reqData.put("authNum", randomNumber);
        smsDao.addAuthNumber(reqData);
        
		return true;
	}
	
	/**
	 * 여러 건의 메세지를 발송해야 할 때 사용
	 * 
	 * @param phoneNumbers
	 * @param msg
	 * @return
	 */
	public boolean postArr(ArrayList<String> phoneNumbers,String msg) {
		ArrayList<Message> messageList = new ArrayList<>();

        for (int i = 0; i < phoneNumbers.size() ; i++) {
            Message message = new Message();
            // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
            message.setFrom(this.fromNumber);
            message.setTo(phoneNumbers.get(i));
            message.setText(msgTitle+msg);

            messageList.add(message);
        }

        try {
            // send 메소드로 단일 Message 객체를 넣어도 동작합니다!
            MultipleDetailMessageSentResponse response = this.messageService.send(messageList);

            // 중복 수신번호를 허용하고 싶으실 경우 위 코드 대신 아래코드로 대체해 사용해보세요!
            //MultipleDetailMessageSentResponse response = this.messageService.send(messageList, true);

            System.out.println(response);

            return true;
        } catch (NurigoMessageNotReceivedException exception) {
            System.out.println(exception.getFailedMessageList());
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
		return false;
	}
	/**
	 * 메세지 발송 및 잔액 조회
	 * 
	 * @param message
	 * @return
	 */
	private SingleMessageSentResponse sendMsg(Message message) {
		final DefaultMessageService messageService = NurigoApp.INSTANCE.initialize(this.apiKey, this.apiSecretKey, "https://api.coolsms.co.kr");
		
		// 잔액 조회
		Balance balance = messageService.getBalance();
		System.out.println(balance);
		return messageService.sendOne(new SingleMessageSendingRequest(message));
	}
	
}
