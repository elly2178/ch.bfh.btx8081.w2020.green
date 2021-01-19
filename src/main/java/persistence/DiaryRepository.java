package persistence;

import model.common.Diary;

import javax.persistence.EntityManager;

//TO BE ALLOCATED PROPERLY
public class DiaryRepository {

    private EntityManager em;

    public DiaryRepository() {
        em = DBManager.getInstance().getEntityManager();
    }

    public void addDiary(Diary diary){
        em.getTransaction().begin();
        em.persist(diary);
        em.getTransaction().commit();
        em.close();
    }


}
