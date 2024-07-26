package org.example.texttime.auth.repository;


import org.example.texttime.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.BindParam;

@Repository
public interface AuthRepository extends JpaRepository<UserEntity, Integer> {
    @Modifying
    @Query(value = """
            INSERT INTO
                c_user (username, email, password)
            VALUES
                (:username, :email, :password)
            """, nativeQuery = true)
    Integer createUser(@BindParam ("username") String username, @BindParam ("email") String email, @BindParam("password") String password);
    @Override
    UserEntity getById(Integer id);
}
