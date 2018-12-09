package com.terima.todo.generators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.terima.todo.constants.DateFmtUtils;

/**
 * @author vignesh
 *
 */
public class UserIdGenerators  implements IdentifierGenerator {
	
	private static final String UID_STR = "UID";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String dateFmt = DateFmtUtils.getDateByHHYYMMMMSSDD();
		return Long.valueOf(dateFmt);
	}
}
