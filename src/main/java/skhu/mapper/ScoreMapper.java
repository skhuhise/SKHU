package skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import skhu.dto.Score;

@Mapper
public interface ScoreMapper {
	List<Score> findByStudentId(int studentId);
	List<Score> findBySubstitutionCode(@Param("studentId") int studentId, @Param("substitutionCode") String substitutionCode);
}
