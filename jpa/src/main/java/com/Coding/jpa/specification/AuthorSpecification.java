package com.Coding.jpa.specification;

import com.Coding.jpa.models.Author;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AuthorSpecification {

    public static Specification<Author> hasAge(int age) {
        return (root, query, cb) -> cb.equal(root.get("age"), age);
    }

    public static Specification<Author> firstnameContains(String fragment) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("firstName")), "%" + fragment.toLowerCase() + "%");
    }

    /**
     * Fetch the courses collection in the same SQL to avoid LazyInitializationException
     */
    public static Specification<Author> fetchCourses() {
        return (root, query, cb) -> {
            // only do this on root queries (to avoid subquery errors)
            if (Author.class.equals(query.getResultType())) {
                root.fetch("courses", JoinType.LEFT);
                query.distinct(true);
            }
            return cb.conjunction();
        };
    }
}
