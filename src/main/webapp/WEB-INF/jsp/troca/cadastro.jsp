<div class="mb-3">
            <label for="tipoTroca">Tipo de Troca:</label>
            <select class="form-select" id="tipoTroca" name="tipoTroca">
                <option value="Upgrade" ${avaliacao.tipoTroca == 'Upgrade' ? 'selected' : ''}>Upgrade</option>
                <option value="Downgrade" ${avaliacao.tipoTroca == 'Downgrade' ? 'selected' : ''}>Downgrade</option>
                <option value="Troca Similar" ${avaliacao.tipoTroca == 'Troca Similar' ? 'selected' : ''}>Troca Similar</option>
            </select>
        </div>

<div class="mb-3">
            <label for="valorTroca">Valor da Troca:</label>
            <input type="number" step="0.01" class="form-control" id="valorTroca" name="valorTroca" value="${avaliacao.valorTroca}" placeholder="Digite o valor da troca">
</div>

            <div class="mb-3">
                        <label for="codigoTroca">Codigo da Troca:</label>
                        <input type="text" class="form-control" id="codigoTroca" name="codigoTroca" value="${avaliacao.codigoTroca}" placeholder="Digite o codigo da troca">
                    </div>
