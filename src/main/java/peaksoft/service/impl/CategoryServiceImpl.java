package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import peaksoft.repo.CategoryRepo;
import peaksoft.service.CategoryService;

@Service
@RequiredArgsConstructor
@Slf4j

public class CategoryServiceImpl {
private final CategoryRepo categoryRepo;


}
