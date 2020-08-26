package training.converter;

public interface IConverter<M, E> {
	M toModel(E entity);
	E toEntity(M model);
}
