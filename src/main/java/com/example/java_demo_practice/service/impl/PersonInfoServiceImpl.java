package com.example.java_demo_practice.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_practice.entity.PersonInfo;
import com.example.java_demo_practice.repository.PersonInfoDao;
import com.example.java_demo_practice.service.ifs.PersonInfoService;
import com.example.java_demo_practice.vo.PersonInfoRequest;
import com.example.java_demo_practice.vo.PersonInfoRequestA;
import com.example.java_demo_practice.vo.PersonInfoResponse;
import com.example.java_demo_practice.vo.PersonInfoResponseA;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public PersonInfoResponse addPersonInfo(PersonInfoRequest request) {
		PersonInfo reqInfo = request.getPersonInfo();
		if (!StringUtils.hasText(reqInfo.getId()) || !StringUtils.hasText(reqInfo.getName())) {
			return new PersonInfoResponse("�п�J�����T");
		}
		if (personInfoDao.existsById(reqInfo.getId())) {
			return new PersonInfoResponse("ID�w�s�b");
		}
		personInfoDao.save(reqInfo);
		return new PersonInfoResponse(reqInfo, "�Ыا���");
	}

	@Override
	public PersonInfoResponseA addPersonInfo(PersonInfoRequestA personInfoRequest) {
		String id = personInfoRequest.getId();
		String name = personInfoRequest.getName();
		Integer age = personInfoRequest.getAge();
		if (!StringUtils.hasText(id) || !StringUtils.hasText(name)) {
			return new PersonInfoResponseA("�п�J�����T");
		}
		if (personInfoDao.existsById(id)) {
			return new PersonInfoResponseA(id, "ID�w�s�b");
		}
		PersonInfo personInfo = new PersonInfo(id, name, age);
		PersonInfo result = personInfoDao.save(personInfo);
		return new PersonInfoResponseA(result.getId(), result.getName(), result.getAge(), "�Ыا���");
	}

	@Override
	public List<PersonInfo> getPersonInfo() {
		List<PersonInfo> info = personInfoDao.findAll();
		return info;
	}

//	@Override
//	public PersonInfoResponse getPersonInfoById(PersonInfoRequest personInfoRequest) {
//		String id = personInfoRequest.getId();
//		if (!StringUtils.hasText(id)) {
//			System.out.println("�п�JID");
//		}
//		Optional<PersonInfo> checkId = personInfoDao.findById(id);
//		if (!checkId.isPresent()) {
//			return new PersonInfoResponse(id, "�d�L��ID");
//		}
//		PersonInfo personInfo = checkId.get();
//		return new PersonInfoResponse(personInfo.getId(), personInfo.getName(),
//				personInfo.getAge());
//	}

	@Override
	public List<PersonInfo> getPersonInfoByAgeLargerThan(int age) {
		getPersonInfo();
		Iterator<PersonInfo> it = getPersonInfo().iterator();
		while (it.hasNext()) {

		}
		return null;
	}

//	@Override
//	public PersonInfoResponseA addPersonInfo(PersonInfoRequestA personInfoRequest) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public PersonInfoResponse getPersonInfoById(PersonInfoRequest personInfoRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
