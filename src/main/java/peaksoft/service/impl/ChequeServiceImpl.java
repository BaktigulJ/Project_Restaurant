package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import peaksoft.repo.ChequeRepo;

@Service
@RequiredArgsConstructor
@Slf4j

public class ChequeServiceImpl {
    private final ChequeRepo chequeRepo;

}
