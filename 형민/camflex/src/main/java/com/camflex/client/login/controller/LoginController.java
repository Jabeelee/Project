package com.camflex.client.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camflex.client.login.service.LoginService;

import com.camflex.client.login.vo.LoginVO;
import com.camflex.client.member.vo.MemberVO;

@Controller
public class LoginController {
	// 로깅을 위한 변수
	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private JavaMailSenderImpl mailSender;

	/* 로그인 페이지 */
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String LoginForm() {
		log.info("로그인 페이지 호출 성공");
		return "/login/login"; // views/login/login.jsp로 포워드
	}

	/* 로그인 기능 */
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(LoginVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		HttpSession session = req.getSession();
		LoginVO login = loginService.loginCheck(vo);

		if (login == null) {
			log.info("login false");
			session.setAttribute("login", null);
			rttr.addFlashAttribute("msg", false);
			return "/login/loginForm";
		} else {
			log.info("login Success");
			session.setAttribute("login", login);
		}
		return "/login/login";
	}

	/* 아이디 찾기 페이지 */
	@RequestMapping(value = "findIdForm", method = RequestMethod.GET)
	public String findIdForm() {
		log.info("아이디 찾기 페이지 호출 성공");
		return "/login/findId"; // views/login/findId.jsp로 포워드
	}

	/* 아이디 찾기 */
	@RequestMapping(value = "findId", method = RequestMethod.POST)
	public String findId(MemberVO vo, Model model, RedirectAttributes rttr) throws Exception {
		log.info("findId post");
		MemberVO mvo = loginService.findId(vo);

		if (mvo == null) {
			log.info("find ID 실패");
			model.addAttribute("mvo", null);
			rttr.addFlashAttribute("msg", false);
			return "/login/findId";
		} else {
			log.info("find ID 성공");
			model.addAttribute("mvo", mvo);
		}
		return "/login/findId";
	}

	/* 비밀번호 찾기 페이지 */
	@RequestMapping(value = "findPwForm", method = RequestMethod.GET)
	public String findPwForm() {
		log.info("비밀번호 찾기 페이지 호출 성공");
		return "/login/findPw"; // views/login/findPw.jsp로 포워드
	}

	/* 비밀번호 찾기 인증번호 이메일 발송 */
	/* 이름과 아이디, 전화번호로 인증받는다. */
	@RequestMapping(value = "findPw", method = RequestMethod.POST)
	public ModelAndView findPw(HttpServletRequest request, String m_name, String m_id,
			HttpServletResponse response_m_id) throws IOException {
		Random r = new Random();
		int dice = r.nextInt(157211) + 48271;

		String setfrom = "dlgudals0011@gmail.com"; // 보내는 사람(사이트 관리자)
		String tomail = request.getParameter("m_id"); // 받는 사람의 이메일(아이디 m_id)
		String title = "camflex 캠핑장에서 인증번호를 보냅니다!"; // 제목
		String content =
				// 내용
				System.getProperty("line.separator") + System.getProperty("line.separator") + "안녕하십니까!"
						+ System.getProperty("line.separator") + System.getProperty("line.separator")
						+ "요청하신 비밀번호 찾기 인증번호는 " + dice + " 입니다." + System.getProperty("line.separator")
						+ System.getProperty("line.separator") + "받으신 인증번호를 홈페이지에 입력해 주시면 비밀번호 수정 페이지로 넘어갑니다 :)";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는 사람 생략하면 정상작동X
			messageHelper.setTo(tomail); // 받는 사람 이메일(아이디 m_id)
			messageHelper.setSubject(title); // 메일제목은 생략 가능
			messageHelper.setText(content);// 메일 내용

			mailSender.send(message);

		} catch (Exception e) {
			System.out.println(e);
		}

		ModelAndView mav = new ModelAndView(); // ModelAndView로 보낼 페이지 지정
		mav.setViewName("/login/findPw_CCN"); // 인증번호.jsp 뷰
		mav.addObject("dice", dice);
		mav.addObject("m_id", m_id);

		log.info("dice : " + dice);
		log.info("mav : " + mav);

		response_m_id.setContentType("text/html; charset=UTF-8");
		PrintWriter out_m_id = response_m_id.getWriter();
		out_m_id.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
		out_m_id.flush();

		return mav;
	}

	/* 인증번호 받고 인증 후 비밀번호 변경 페이지로 넘어가는 컨트롤러 */
	// Certification Number = CCN
	@RequestMapping(value = "CCN.do{dice},{m_id}", method = RequestMethod.POST)
	public ModelAndView CCN(String CCN, @PathVariable String dice, @PathVariable String m_id,
			HttpServletResponse response_equals) throws IOException {
		log.info("마지막 : CCN : " + CCN);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login/findPw_change");
		mav.addObject("m_id", m_id);

		if (CCN.equals(CCN)) {
			// 인증번호 일치하면 비밀번호 변경 페이지로 이동
			mav.setViewName("/login/findPw_change");
			mav.addObject("m_id", m_id);

			response_equals.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response_equals.getWriter();
			out_equals.println("<script>alert('인증번호가 일치합니다. 비밀번호 변경 페이지로 이동합니다.');</script>");
			out_equals.flush();

			return mav;
		} else if (CCN != CCN) {
			// 인증번호가 틀릴 경우 alert창
			ModelAndView mav2 = new ModelAndView();

			// 다시 인증번호 입력 페이지로 이동
			mav2.setViewName("/login/findPw_CCN");

			response_equals.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response_equals.getWriter();
			out_equals.println("<script>alert('인증번호가 일치하지 않습니다. 다시 입력해주세요.'); history.go(-1);</script>");
			out_equals.flush();

			return mav2;
		}
		return mav;
	}

	/* 변경할 비밀번호를 입력후 확인 버튼을 누르면 넘어가는 컨트롤러 */
	@RequestMapping(value = "change_pw.do{m_id}", method = RequestMethod.POST)
	public ModelAndView change_pw(@PathVariable String m_id, HttpServletRequest request, MemberVO mvo,
			HttpServletResponse pass) throws Exception {
		String m_pw = request.getParameter("m_pw");

		String m_id1 = m_id;

		mvo.setM_id(m_id1);
		mvo.setM_pw(m_pw);

		Map<String, Object> map = new HashMap<>();

		map.put("m_id", mvo.getM_id());
		map.put("m_pw", mvo.getM_pw());
		loginService.change_pw(map, mvo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/login/pw_result");
		return mav;

	}

}
