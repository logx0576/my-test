package me.logx.bean;

public class PetService {
	private PetDao petDao;

	public PetDao getPetDao() {
		return petDao;
	}

	public void setPetDao(PetDao petDao) {
		this.petDao = petDao;
	}
}
