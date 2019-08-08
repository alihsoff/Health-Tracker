/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.List;

/**
 *
 * @author Ali Huseynov
 */
public interface DatabaseInter<E> {
    public List<E> getAll();
    public boolean update(E e);
    public boolean insert(E e);
    public boolean deleteFromId(int id);
    public E getById(int Id);
}
