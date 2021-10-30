package enit.bank.repository;

public interface ReviewRepository extends PagingAndSortingRepository<onereview, String> {

	Iterable<onereview> findByProductId(@Param("productId") String productId);
}
