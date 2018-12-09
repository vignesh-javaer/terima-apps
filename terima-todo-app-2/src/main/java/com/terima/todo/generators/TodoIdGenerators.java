/**
 * 
 */
package com.terima.todo.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.terima.todo.constants.DateFmtUtils;


/**
 * @author vignesh
 *
 */
public class TodoIdGenerators  implements IdentifierGenerator {
	

	private static Integer sequNum;
	
	static {
		final Random rm = new Random();
		sequNum = rm.ints(0, 999).findFirst().getAsInt();
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		final String dateFmt = DateFmtUtils.getDateByYYYYMMDDHHMMSS();
		final String genSeq = dateFmt.concat(sequNum+"");
		return Long.valueOf(genSeq);
	}

}
