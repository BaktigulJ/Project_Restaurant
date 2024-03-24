package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import peaksoft.repo.MenuItemRepo;

@Service
@RequiredArgsConstructor
@Slf4j

public class MenuItemServiceImpl {
 private final MenuItemRepo menuItemRepo;
}
