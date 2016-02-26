package com.xinfan.wxshop.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xinfan.wxshop.business.dao.DeliveryAddressDao;
import com.xinfan.wxshop.business.entity.DeliveryAddress;
import com.xinfan.wxshop.business.entity.DeliveryAddressExample;

public class DeliveryAddressService {

	@Autowired
	private DeliveryAddressDao deliveryAddressDao;

	public void addDeliverAddress(DeliveryAddress vo) {
		vo.setSort(0);
		deliveryAddressDao.insertSelective(vo);
	}

	public void deleteDeliverAddress(int deliveryId) {
		deliveryAddressDao.deleteByPrimaryKey(deliveryId);
	}

	public DeliveryAddress getDeliverAddress(int deliveryId) {
		return deliveryAddressDao.selectByPrimaryKey(deliveryId);
	}

	public void updateDeliverAddress(DeliveryAddress vo) {
		vo.setSort(0);
		deliveryAddressDao.updateByPrimaryKeySelective(vo);
	}

	public void updateDefaultDeliverAddress(int id) {

		DeliveryAddress exist = deliveryAddressDao.selectByPrimaryKey(id);
		if (exist != null) {
			DeliveryAddress vo = new DeliveryAddress();
			vo.setIsdefault(0);
			DeliveryAddressExample example = new DeliveryAddressExample();
			example.createCriteria().andCustomerIdEqualTo(exist.getCustomerId());
			deliveryAddressDao.updateByExampleSelective(vo, example);

			DeliveryAddress vo2 = new DeliveryAddress();
			vo2.setIsdefault(1);
			vo2.setDeliveryId(id);

			deliveryAddressDao.updateByPrimaryKeySelective(vo2);
		}
	}

	public List<DeliveryAddress> getCustomerDeliveryAddressList(int customerId) {
		DeliveryAddressExample example2 = new DeliveryAddressExample();
		example2.createCriteria().andCustomerIdEqualTo(customerId);
		example2.setOrderByClause("isdefault desc ,sort desc");
		List<DeliveryAddress> list2 = deliveryAddressDao.selectByExample(example2);
		return list2;
	}

	public DeliveryAddress getSugestDeliverAddress(int customerId) {
		DeliveryAddressExample example = new DeliveryAddressExample();
		example.createCriteria().andIsdefaultEqualTo(1).andCustomerIdEqualTo(customerId);
		List<DeliveryAddress> list = deliveryAddressDao.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			DeliveryAddressExample example2 = new DeliveryAddressExample();
			example2.createCriteria().andCustomerIdEqualTo(customerId);
			List<DeliveryAddress> list2 = deliveryAddressDao.selectByExample(example2);
			if (list2.size() > 0) {
				DeliveryAddress address = list2.get(0);
				address.setIsdefault(1);
				deliveryAddressDao.updateByPrimaryKeySelective(address);
				return address;
			}
		}
		return null;
	}

	public List<DeliveryAddress> getLastDeliverAddress(int customerId) {
		return deliveryAddressDao.selectTopListByExample(customerId, 5);
	}

}
