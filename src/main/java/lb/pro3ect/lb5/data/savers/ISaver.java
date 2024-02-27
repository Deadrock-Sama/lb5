package lb.pro3ect.lb5.data.savers;

import lb.pro3ect.lb5.data.IWorkersRepository;


public interface ISaver {

    void save(IWorkersRepository repository);

    IWorkersRepository load();


}
